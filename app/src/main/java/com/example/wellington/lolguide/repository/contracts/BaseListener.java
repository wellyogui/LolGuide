package com.example.wellington.lolguide.repository.contracts;

/**
 * Created by wellington on 19/12/16.
 */

public interface BaseListener {
    /**
     * Api Started Loading      * Time to show loading screen
     */
    void onRequestStarted();

    /**
     * Api Finished Loading      * Time to dismiss loading screen
     */
    void onRequestFinished();

    /**
     * Error occured      *      * @param error - Exception
     */
    void onError(Throwable error);
}