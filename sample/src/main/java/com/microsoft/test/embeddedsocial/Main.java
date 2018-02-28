package com.microsoft.test.embeddedsocial;

/**
 * Created by ssaroiu on 2/28/2018.
 */

public class Main {
    public static SyncExample syncExample = new SyncExample();

    public static void main(String[] args) {

        // syncExample makes single synchronous call
        syncExample.run();
    }
}
