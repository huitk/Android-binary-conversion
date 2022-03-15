# Android-binary-conversion
Step 1:

• Create a new Android project.
• The first step is to modify activity_main.xml to create a user
  inteface that has the same widgets as the app below. You can do the modification directly in xml or using a graphical tool.
• You can use either multiple Linear Layouts,a RelativeLayout, Table Layout or a Constraint Layout to place the widgets on the screen.
• Use radio buttons for the different formats. You will need to put your RadioButtons into a RadioGroup – this will make sure only 
  one button is “pressed” at a time.
• Run your app. It won’t be able to do anything but should look like you want your app to look.

Step 2:

• Now you are going to do some simple wiring. In your XML
  layout, add identifiers to each of the widgets you are going to use. For example, android:id=”@+id/input_value” could be used for the 
  first EditText widget.
• Use your radio buttons to set a variable ‘base’ to 2,8,10 or 16. Be sure to set a default value (I used 10) and to mark that radio button
  as pressed.
• You will also want to keep a single variable that holds the current user input value (in decimal) from the EditText. Give a default of 0. 
  Use this to print out the table when the base changes (i.e. a radio button is clicked). I used string functions toHexString(), toOctalString(), 
  toBinaryString() to get the strings I wanted.
• Addalistenertothe‘convert’buttonthatusesthecurrentEditTextvalue(asastring numberstring) and current base (as was set by the radio button listener) 
  Integer.parseInt(numberstring,base)to get the decimal value of the input based on the current ‘base’ specified by the radio buttons. Note that 
  until you do step 3 below, the app will die if you try to do this conversion on an illegal input.
• Test your code by running the app and playing with it a little.

Step 3:

• Finally, add some error checking and input controls:
• Error checking: You may have noticed that parseInt raises an exception if the input string is illegal for the given base. Add exception handling to prevent the app dying and use Toast to provide an error message, like the example to the right. An example of Toast is in the slides.
• Control the legal input: For binary, octal and decimal, we only need integer input. You control the keyboard in the java code for the radio buttons by using:
inputNum.setInputType(InputType.TYPE_CLASS_NUMBER); and
inputNum.setInputType(InputType.TYPE_CLASS_TEXT);
