package ru.yandex.yamblz.concurrency;

import android.support.annotation.NonNull;

import java.util.Set;

/**
 * Simple load producer thread; non-extensible
 *
 * @author archinamon on 13/07/16.
 */

public final class LoadProducer extends Thread {

    @NonNull private final Set<String> results;
    @NonNull private final Runnable onResult;

    public LoadProducer(@NonNull Set<String> resultSet, @NonNull Runnable onResult) {
        this.results = resultSet;
        this.onResult = onResult;
    }

    @Override
    public void run() {
        super.run();

        /* Synchronize via concurrent mechanics */

        final String result = new DownloadLatch().doWork();
        results.add(result);

        onResult.run();
    }
}
