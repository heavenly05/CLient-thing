package com.ACJ.Heaven.Utilities.Time;




import java.util.concurrent.TimeUnit;

public class Timuh {
    protected boolean isFinished = false;
    protected long millisecs;
    protected long secs;
    public long iterator = 0;
    protected long minutes;
    protected final long timeStarted = CurrentTime.getNanoSeconds();
    protected long elapsedTime;
    public long endTime;
    public Runnable onTimerFinish;

    public Timuh(long duration, int unit, Runnable onFinish) throws Exception {
        switch (unit) {
            case TIME_UNIT.UNIT_MILLISECONDS -> {
                this.millisecs = duration;
                this.secs = (duration / 1000);
                this.minutes = (this.secs / 60);
                onTimerFinish = onFinish;
                this.endTime = (long)(this.millisecs * 1e6);
            }
            case TIME_UNIT.UNIT_SECONDS -> {
                this.secs = duration;
                this.millisecs = (this.secs * 1000L);
                this.minutes = (this.secs / 60);
                onTimerFinish = onFinish;
                this.endTime = (long)(this.millisecs * 1e6);
            }
            case TIME_UNIT.UNIT_MINUTES -> {
                this.minutes = duration;
                this.secs = (this.minutes * 60L);
                this.millisecs = (long)(this.secs * 1000L);
                onTimerFinish = onFinish;
                this.endTime = (long)(this.millisecs * 1e6);
            }
            case TIME_UNIT.UNIT_HOURS -> {
                this.minutes = (duration * 60);
                this.secs = (this.minutes * 60);
                this.millisecs = (long)(this.secs * 1000L);
                this.onTimerFinish = onFinish;
                this.endTime = (long)(this.millisecs * 1e6);
            }
            default -> throw new Exception("Invalid Unit of Time");
        }

    }
    public Timuh(long duration, time_unit timeUnit, Runnable onFinish){
        if(null != timeUnit)
        switch (timeUnit) {
            case milliseconds -> {
                this.millisecs = duration;
                this.secs = (duration / 1000);
                onTimerFinish = onFinish;
                this.endTime = (long)(this.millisecs * 1e6);
            }
            case seconds -> {
                this.secs = duration;
                this.millisecs = (this.secs * 1000L);
                onTimerFinish = onFinish;
                this.endTime = (long)(this.millisecs * 1e6);
            }
            case minutes -> {
                this.secs = (duration * 60);
                this.millisecs = (long)(this.secs * 1000L);
                onTimerFinish = onFinish;
                this.endTime = (long)(this.millisecs * 1e6);
            }
            case hours -> {
                this.minutes = (duration * 60);
                this.secs = (duration * 60);
                this.millisecs = (long)(this.secs * 1000L);
                onTimerFinish = onFinish;
                this.endTime = (long)(this.millisecs * 1e6);
            }
            default -> {
            }
        }
    }

    public void startTimer() throws InterruptedException {
        for(this.iterator = 0; this.iterator <= (millisecs * 1e6); this.iterator++){
            if((elapsedTime <= endTime)){
                //run while there is still time
                TimeUnit.NANOSECONDS.sleep(1L);
                this.elapsedTime = getElapsedTime();
            }else{
                end();
                break;
            }
        }
    }

    public void end() throws InterruptedException {
        onTimerFinish.run();
    }


    public boolean isTimerFinished(){
        return isFinished;
    }

    public void reset(){
        this.elapsedTime = 0;
        this.iterator = 0;
    }


    public long getNanoSeconds(){
        return (long)(getMilliseconds() * 1e6);
    }
    public long getMilliseconds(){
        return millisecs;
    }
    public long getSeconds(){
        return secs;
    }
    public long getMinutes(){
        return this.minutes;
    }



    public long getTimeStarted() {
        return timeStarted;
    }

    public long getElapsedTime(){
        return (System.nanoTime() - timeStarted);
    }

     public enum time_unit{
        milliseconds,
        seconds,
        minutes,
        hours
    }
}
