package org.study.coroutine

import kotlinx.coroutines.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.Executors

// Coroutine = lightweight thread
// parallel + concurrent

val logger: Logger = LoggerFactory.getLogger("CoroutinesPlayground")

suspend fun bathTime() {
    // Continuation = data structure stores all local context
    logger.info("Going to the bathroom")
    delay(500L) // suspends/"blocks" the computation
    // Continuation restored here
    logger.info("Bath done, exiting")
}

suspend fun boilingWater() {
    logger.info("Boiling water")
    delay(1000L)
    logger.info("Water boiled")
}

suspend fun sequentialMorningRoutine() {
    coroutineScope { // start a "context" for coroutines
        bathTime()
        // add more code, including suspending functions
        // parallel code here, all needs to finish before the scope is closed
    }
    coroutineScope {
        boilingWater()
    }
}

suspend fun concurrentMorningRoutine() {
    coroutineScope {
        launch { bathTime() } // this coroutine is a CHILD of the coroutineScope
        launch { boilingWater() }
    }
}

suspend fun noStructConcurrencyMorningRoutine() {
    val bathJob = GlobalScope.launch { bathTime() }
    val waterJob = GlobalScope.launch { boilingWater() }
}

suspend fun makeCoffee() {
    logger.info("Starting to make coffee")
    delay(500L)
    logger.info("Done with coffee")
}

// plan coroutines

/*
    take a bath
    start the boiling water

    after both are done => eat my coffee

 */

suspend fun morningRoutineWithCoffee() {
    coroutineScope {
        val bathTimeJob: Job = launch { bathTime() }
        val boilingWaterJob: Job = launch { boilingWater() }
        bathTimeJob.join()
        boilingWaterJob.join()
        launch { makeCoffee() }
    }
}

suspend fun morningRoutineWithCoffeeStructured() {
    coroutineScope {
        coroutineScope {
            // parallel jobs
            launch { bathTime() }
            launch { boilingWater() }
        }
        // both coroutines are done
        launch { makeCoffee() }
    }
}

// return values from coroutines
suspend fun preparingJavaCoffee(): String {
    logger.info("Starting to make coffee")
    delay(500L)
    logger.info("Done with coffee")
    return "Java coffee"
}

suspend fun toastingBread(): String {
    logger.info("Starting to toast breakfast")
    delay(500L)
    logger.info("Toast is out!")
    return "Toasted bread"
}

suspend fun prepareBreakfast() {
    coroutineScope {
        val coffee = async { preparingJavaCoffee() } // Deferred = analogous to Future[T]
        val toast = async { toastingBread() }
        // semantic blocking
        val finalCoffee = coffee.await()
        val finalToast = toast.await()
        logger.info("I'm eating $finalCoffee and $finalToast")
    }
}

// 1 - cooperative scheduling - coroutines yield manually
suspend fun workingHard() {
    logger.info("Working")
    // CPU-intensive computation
    while (true) {
        // do some hard code
    }
    delay(100L)
    logger.info("Work done")
}

suspend fun workingNicely() {
    logger.info("Working")
    // CPU-intensive computation
    while (true) {
        delay(100L) // give a chance for the dispatcher to run another coroutine
    }
    delay(100L)
    logger.info("Work done")
}

suspend fun takeABreak() {
    logger.info("Taking a break")
    delay(1000L)
    logger.info("Break done")
}

suspend fun workHardRoutine() {
    val dispatcher: CoroutineDispatcher = Dispatchers.Default.limitedParallelism(1) // force 1 thread
    coroutineScope {
        launch(dispatcher) { workingHard() }
        launch(dispatcher) { takeABreak() }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun workNicelyRoutine() {
    val dispatcher: CoroutineDispatcher = Dispatchers.Default.limitedParallelism(1) // force 1 thread
    coroutineScope {
        launch(dispatcher) { workingNicely() }
        launch(dispatcher) { takeABreak() }
    }
}

val simpleDispatcher = Dispatchers.Default // "normal code" = short code or yielding coroutines
val blockingDispatcher = Dispatchers.IO // blocking code {e.g. DB connections, long-running computations}
val customDispatcher = Executors.newFixedThreadPool(8).asCoroutineDispatcher() // on top of your own thread pool

// cancellation
suspend fun forgettingFriendBirthDayRoutine() {
    coroutineScope {
        val workingJob = launch { workingNicely() }
        launch {
            delay(2000L) // after 2s I remember I have a birthday today
            workingJob.cancel() // sends a SIGNAL to ther coroutine to cancel, cancellation happens at first yielding point
            workingJob.join() // you are sure that the coroutine has been cancelled
            logger.info("I forgot my friend's birthday! Buying a present now!")
        }
    }
}

// if a coroutine does not yield, it cannot be cancelled
suspend fun forgettingFriendBirthDayRoutineUncancelable() {
    coroutineScope {
        val workingJob = launch { workingHard() }
        launch {
            delay(2000L)
            logger.info("Trying to to stop working")
            workingJob.cancel() // sends a SIGNAL to the coroutine to cancel, cancellation happens at first yielding point(NEVER)
            workingJob.join() // you are sure that the coroutine has been cancelled
            logger.info("I forgot my friend's birthday! Buying a present now!")
        }
    }
}

// resources
class Desk : AutoCloseable {
    init {
        logger.info("Starting to work on this desk")
    }

    override fun close() {
        logger.info("Cleaning up the desk")
    }
}

suspend fun forgettingFriendBirthDayRoutineWithResource() {
    val desk = Desk()
    coroutineScope {
        val workingJob = launch {
            // use the resource here
            desk.use { _ -> // this resource will be closed upon completion of the coroutine
                workingNicely()
            }
        }
        // can also define your own "cleanup" code in case of completion
        workingJob.invokeOnCompletion { exception: Throwable? ->
            // can handel completion and cancellation differently, depending on the exception
            logger.info("Make sure I talk to my colleagues that I'll be out for 30 mins")
        }

        launch {
            delay(2000L)
            logger.info("Trying to to stop working")
            workingJob.cancel() // sends a SIGNAL to the coroutine to cancel, cancellation happens at first yielding point(NEVER)
            workingJob.join() // you are sure that the coroutine has been cancelled
            logger.info("I forgot my friend's birthday! Buying a present now!")
        }
    }
}

// cancellation propagates th child coroutines
suspend fun drinkWater() {
    while (true) {
        logger.info("Drinking water")
        delay(1000L)
    }
}

suspend fun forgettingFriendBirthDayRoutineStayHydrated() {
    coroutineScope {
        val workingJob = launch {
            launch { workingNicely() }
            launch { drinkWater() }
        }
        launch {
            delay(2000L) // after 2s I remember I have a birthday today
            workingJob.cancel() // sends a SIGNAL to ther coroutine to cancel, cancellation happens at first yielding point
            workingJob.join() // you are sure that the coroutine has been cancelled
            logger.info("I forgot my friend's birthday! Buying a present now!")
        }
    }
}

// coroutine context
suspend fun asynchronousGreeting() {
    coroutineScope {
        launch(CoroutineName("Greeting Coroutine") + Dispatchers.Default /* these two = CoroutineContext */) {
            logger.info("Hello, everyone!")
        }
    }
}

suspend fun demoContextInheritance() {
    coroutineScope {
        launch(CoroutineName("Greeting Coroutine")) {
            logger.info("[parent coroutine] Hello!")
            launch(CoroutineName("Child Greeting Coroutine")) { // coroutine context will be inherited here
                logger.info("[child coroutine] Hi there!")
            }
            delay(200L)
            logger.info("[parent coroutine] Hi again from parent!")
        }
    }
}

suspend fun main(args: Array<String>) {
    demoContextInheritance()
}
