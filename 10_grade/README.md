# Slides for 10th grade

## Logic
https://docs.google.com/presentation/d/17W0Gay5kItaN5XKANmjqj1bbODcHA4Na9Y5NbRuKhm8/edit?usp=sharing



## Math 

https://docs.google.com/presentation/d/1Soc2XqOkzGYxEeFxfiBkEb86pwW9zkK_BWO-Hx0tasw/edit?usp=sharing

## Functions

https://docs.google.com/presentation/d/1pxK1cZBL6jjGPCMmE4FM9FII6q_jnifBrcGbdE5HN10/edit?usp=sharing


## Loops

https://docs.google.com/presentation/d/1rqG2gRPN8o97JZc8eKr3qrO3o_CCFtWEtEapUBOYf_8/edit?usp=sharing

### Nested loops

https://docs.google.com/presentation/d/1Tqi4GI1g1Ut5UKPGg2bNM15IccoLi-xr8kTUpepWNcE/edit?usp=sharing


## Object-Oriented-Programming

https://docs.google.com/presentation/d/1278UWIQf01JocEVuq3jGdT7LTVe7WA59471Bb_9Yv8o/edit?usp=sharing


## Arrays

https://docs.google.com/presentation/d/1K4JqNBQWkm2ZlFINnTZhaTivlUJfoptcuv6pTX2cbOA/edit?usp=sharing

### Sorting Arrays

https://www.youtube.com/watch?v=RfXt_qHDEPw

https://www.youtube.com/watch?v=0lOnnd50cGI


### Advabced arrays

https://docs.google.com/presentation/d/1UVCprTVgD7udZb1x1KfXQoW_cq8XEzWUBvyiQluGd7w/edit?usp=sharing


## Reading from files

### Imports:

```
	import java.io.File;
	import java.io.IOException;
	import java.io.BufferedReader;
	import java.io.FileReader;

```

### Definitions and loop

```
        File myFile = new File(PATH_TO_FILE);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(myFile));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

```

### Library `main()` function

```
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class myLib {
    public static void main(String[] args) {

        Book mybook = new Book("harry potter");
        mybook.setBox(120);
	Library ourLib = new Library("Beer Sheva");
	ourLib.addBook(mybook);
        System.out.println(mybook);
        File myFile = new File(PATH_TO_FILE);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(myFile));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

	

    }
}
```
