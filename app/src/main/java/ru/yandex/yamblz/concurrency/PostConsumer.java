package ru.yandex.yamblz.concurrency;

import android.support.annotation.NonNull;

import java.util.concurrent.CountDownLatch;

import ru.yandex.yamblz.ui.fragments.ContentFragment;

/**
 * Simple result consumer thread; non-extensible
 *
 * @author archinamon on 13/07/16.
 */

public final class PostConsumer extends Thread {

    @NonNull private final Runnable onFinish;
    private final CountDownLatch latch;
    private final ContentFragment context;

    public PostConsumer(ContentFragment context, CountDownLatch latch, @NonNull Runnable onFinish) {
        this.onFinish = onFinish;
        this.latch = latch;
        this.context = context;
    }

    @Override
    public void run() {
        super.run();

        /* Synchronize via concurrent mechanics */
        try {
            latch.await();
        } catch (Exception e){
        }

        if (context != null) {
            context.runOnUiThread(onFinish);
        }
    }
}
