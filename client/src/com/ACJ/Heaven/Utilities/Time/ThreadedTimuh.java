package com.ACJ.Heaven.Utilities.Time;



import java.util.concurrent.TimeUnit;


public class ThreadedTimuh extends Timuh {
    private boolean isPaused = false;
    private final Runnable threadFunction = () -> {
        try {
            this.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };

    Thread timerThread = new Thread();

    public ThreadedTimuh(long duration, int unit, Runnable onFinish) throws Exception {
        super(duration, unit, onFinish);
    }


    protected void start() throws InterruptedException {
        //System.out.println("Notifying thread: " + Thread.currentThread().getName());
        for (this.iterator = 0; this.iterator < (getNanoSeconds()); this.iterator++) {
            if ((elapsedTime < endTime) && (!isPaused)) {
                //run while there is still time
                TimeUnit.NANOSECONDS.sleep(1L);
                //System.out.println(this.iterator);
                this.elapsedTime = getElapsedTime();
            } else if (isPaused) {
                System.out.println("Is pasued " + this.iterator);
                if (this.iterator >= 1) {
                    this.iterator--;
                } else {
                    this.iterator++;
                }
            } else {
                end();
                break;
            }
        }
    }

    public boolean isTimerPaused() {
        return this.isPaused;
    }

    /**
     * {@code ThreadedTimuh} Extends from its parent class Timuh
     * It allows a timer to run in parallel to other threads making it seamlessy asynchronous and very useful.
     *It takes in a custom Functional interface called {@link Lambda} which allows you to create a custom method to
     *  run after a timer has finished. It can be treated the same as a runnable
     * but with a different naming convention
     * @param duration The duration the timer will last
     * @param timeUnit The unit of time that will be used automatic conversion will be used on the duration
     * @param onFinish The function that will run after the timer has completed a cycle
     *
     */
    public ThreadedTimuh(long duration, time_unit timeUnit, Runnable onFinish) {
        super(duration, timeUnit, onFinish);
    }

    /**
     * Resets the timer by setting the {@code elapsedTime} and {@code iterator} to 0
     */
    @Override
    public void reset() {
        //reset the elapsed time, the iterator to 0 allowing th
        this.elapsedTime = 0;
        this.iterator = 0;
        this.isPaused = false;
    }
    /**
     * Unpauses the timer allowing it to continue to iterate
     */
    public void resumeTimer() throws IllegalStateException {
            if (this.isPaused) {
                //if the timer isn't finished assume the user wants to resume the timer after pausing it
                this.isPaused = false;
            } else if(isFinished){
                throw new IllegalStateException("Timer is finished, you cannot resume from this state");
            }else throw new IllegalStateException("Timer is not Paused");
    }

    /**
     * Starts the timer by waking up the timer-thread. This method is synchronized, meaning only one thread can run it at a time. While the timer is still running, This method will throw and Error if another thread tries to run it again
     *
     * Timer will be unpaused and reset when this method is ran.
     */
    @Override
    public void startTimer() {
            //if the timer isnt paused and isnt finished assume that the user wants to start the timer
            synchronized (this) {
                isPaused = false;
                isFinished = false;
                reset();
                timerThread = new Thread(threadFunction, "timer-thread");
                timerThread.start();
            }
        System.out.println("Starting thread: " + Thread.currentThread().getName());
    }

    @Override
    public void end() throws InterruptedException {
        this.isFinished = true;
        onTimerFinish.run();
    }


    


    /**
     * This method is used to pause the timer. Unlike its parent class which will not be able to stop until its finished
     * The method is synchronized and cant be called by multiple threads at the same time
     */
    public void pauseTimer(){
        synchronized (this) {
            this.isPaused = true;
            //System.out.println("Paused");
        }
    }

   

    




    //measures the time between when the timer started and the current time resulting in the entire time the timer has existed 
    public long getElapsedMilliseconds(){
        //there is 1 million nanoseconds for every millisecond
        //milliseconds * 1m = nanoseconds
        //nanoseconds / 1m = milliseconds
        return (long)(getElapsedTime() / 1e6);
    }
    public long getElapsedSecondsL(){
        //there is 1000 millisecond for every second
        //seconds * 1000 = milliseconds
        //milliseconds / 1000 = seconds
        return (long)(getElapsedMilliseconds() / 1e3);
    }
    public double getElapsedSecondsD(){
       return (getElapsedMilliseconds() / 1e3);
    }
    public long getElapsedMinutes(){
        //there is 60 seconds for every minute
        //seconds * 60 = minutes
        //minutes / 60 = seconds
        return (long)(getElapsedSecondsL() / 60);
    }

}
