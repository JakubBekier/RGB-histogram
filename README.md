# RGB-histogram

Program draws RGB histogram of given image.

# How to use?

Choose a file to analyze.<br>
![alt text](https://github.com/JakubBekier/RGB-histogram/blob/main/readme_images/toAnalyze.png)

Click "Analyze" to create and display results.
![alt text](https://github.com/JakubBekier/RGB-histogram/blob/main/readme_images/resultsV2.png)

# How does it work?

Every pixel of image has values R(ed), G(reen) and B(lue) on a scale of 0 to 255.
Value of color describes intensity. <br>
Program counts how many times every value has occured and displays results in a graph.

Remember that EVERY pixel has all 3 values, so EVERY pixel has value of blue color even
if image is fully red. <br>
Sometimes you can see a graph with the highest peak of color which is
hard to notice, thats because every pixel <br> has low value of this color.
