/*
 * Copyright (C) 2011 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.revinate.guava.util.concurrent;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Utilities for treating interruptible operations as uninterruptible.
 * In all cases, if a thread is interrupted during such a call, the call
 * continues to block until the result is available or the timeout elapses,
 * and only then re-interrupts the thread.
 *
 * @author Anthony Zana
 * @since 10.0
 */
public final class Uninterruptibles {

  // Implementation Note: As of 3-7-11, the logic for each blocking/timeout
  // methods is identical, save for method being invoked.

  // TODO(user): Support Sleeper somehow (wrapper or interface method)?
  /**
   * Invokes {@code unit.}{@link TimeUnit#sleep(long) sleep(sleepFor)}
   * uninterruptibly.
   */
  public static void sleepUninterruptibly(long sleepFor, TimeUnit unit) {
    boolean interrupted = false;
    try {
      long remainingNanos = unit.toNanos(sleepFor);
      long end = System.nanoTime() + remainingNanos;
      while (true) {
        try {
          // TimeUnit.sleep() treats negative timeouts just like zero.
          NANOSECONDS.sleep(remainingNanos);
          return;
        } catch (InterruptedException e) {
          interrupted = true;
          remainingNanos = end - System.nanoTime();
        }
      }
    } finally {
      if (interrupted) {
        Thread.currentThread().interrupt();
      }
    }
  }

  private Uninterruptibles() {}
}
