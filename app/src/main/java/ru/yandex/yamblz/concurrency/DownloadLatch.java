package ru.yandex.yamblz.concurrency;

import android.os.SystemClock;
import android.support.annotation.Nullable;

import java.util.Random;
import java.util.UUID;

/**
 * Task that loads some data and freeze the thread it runs in
 *
 * @author archinamon on 13/07/16.
 */

final class DownloadLatch {

    private static final long THREAD_SLEEP_DELAY = 5000L;
    private final Random random;

    DownloadLatch() {
        this.random = new Random();
    }

    @Nullable
    String doWork() {
        SystemClock.sleep(random.nextInt((int) THREAD_SLEEP_DELAY) + 100);
        return UUID.randomUUID().toString();
    }
}
