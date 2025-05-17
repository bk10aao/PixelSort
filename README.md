# Pixel Sort

This is a Java api to perform the following sorting algorithms:

1. Bubble Sort
2. Bucket Sort
3. Heap Sort
4. In place Merge Sort
5. Insertion Sort
6. Intro/Introspective Sort
7. Least Significant Digit Radix Sort
8. Merge Sort - Bottom Up
9. Merge Sort - Top Down
10. Most Significant Digit Radix Sort
11. Pancake Sort
12. Parallel Merge Sort
13. Quick Sort
14. Selection Sort
15. Shell Sort
16. Tim Sort

# Run The Application

1. Build application `./gradlew clean build`
2. Docker build `docker build --platform linux/arm64 -t pixelsort-app .`
3. Run application `docker run --memory="4g" -p 8080:8080 pixelsort-app`

# Front End

There is a front end application to display the inputs as graphs and provide an animated view of how the algorithms sort the data.

It can be found at repository: https://github.com/bk10aao/PixelSortChakra

To run the front end:

1. `git clone git@github.com:bk10aao/PixelSortChakra.git`
2. `npm run build`
3. `npm run dev`