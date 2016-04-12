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

package com.revinate.guava.math;

import static com.revinate.guava.math.MathPreconditions.checkNoOverflow;

/**
 * A class for arithmetic on values of type {@code long}. Where possible, methods are defined and
 * named analogously to their {@code BigInteger} counterparts.
 *
 * <p>The implementations of many methods in this class are based on material from Henry S. Warren,
 * Jr.'s <i>Hacker's Delight</i>, (Addison Wesley, 2002).
 *
 * @author Louis Wasserman
 * @since 11.0
 */
public final class LongMath {
  // NOTE: Whenever both tests are cheap and functional, it's faster to use &, | instead of &&, ||

  /**
   * Returns the sum of {@code a} and {@code b}, provided it does not overflow.
   *
   * @throws ArithmeticException if {@code a + b} overflows in signed {@code long} arithmetic
   */
  public static long checkedAdd(long a, long b) {
    long result = a + b;
    checkNoOverflow((a ^ b) < 0 | (a ^ result) >= 0);
    return result;
  }

  private LongMath() {}
}
