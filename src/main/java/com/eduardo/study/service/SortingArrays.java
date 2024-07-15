package com.eduardo.study.service;

public class SortingArrays {

  private SortingArrays() {
  }

  public static void mergeSorting(int[] array) {
    int lenght = array.length;
    if (lenght < 2) {
      return;
    }

    int midIndex = lenght / 2;
    int[] leftHalf = new int[midIndex];
    int[] rightHalf = new int[lenght - midIndex];

    for (int i = 0; i < midIndex; i++) {
      leftHalf[i] = array[i];
    }
    for (int i = midIndex; i < lenght; i++) {
      rightHalf[i - midIndex] = array[i];
    }

    mergeSorting(leftHalf);
    mergeSorting(rightHalf);

    merge(array, leftHalf, rightHalf);
  }

  private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
    int leftSize = leftHalf.length;
    int rightSize = rightHalf.length;

    int L = 0;
    int R = 0;
    int A = 0;

    while (L < leftSize && R < rightSize) {
      if (leftHalf[L] <= rightHalf[R]) {
        array[A] = leftHalf[L];
        L++;
      } else {
        array[A] = rightHalf[R];
        R++;
      }
      A++;
    }
    while (L < leftSize) {
      array[A] = leftHalf[L];
      L++;
      A++;
    }
    while (R < rightSize) {
      array[A] = rightHalf[R];
      R++;
      A++;
    }
  }

}
