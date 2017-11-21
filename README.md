# ExtractionLib [![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)

Sometimes we need a lot of files to be downloaded from a server,we can download all of them in the form of jar and then extract your jar file which may carry images, excel files, etc, you don't have need to worry anymore, a lot of code is already there in library.
<br>Just you have to configure a little code in your android activity.

```diff
+First add ExtractionLib in your app level build file as follows 
  dependencies {
	        compile 'com.github.ankitdubey021:ExtractionLib:2.0'
	}


-In project level build file, add the jitpack repository

  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

<h2>
Now in your activity, call the Extract class method with following prototype
</h2>

public class Extract extends ActivityCompat{
   
   public static void extract(File jarfile, String path)throws Exception{
     ---
   }
   
}
```diff
  +Jar file represents the file to be extracted, and path represents where to be extracted

```

<h2>Sample code </h2>
    void extract(){
    
        try {
            File outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "value1.jar");
            Extract.extract(outputFile, new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "extration").toString());

            Toast.makeText(MainActivity.this, "Extracted!", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            System.out.println(e);
        }
    }


<br>
<h3>Make sure, you've asked for permission at runtime to read the file as follows, otherwise you'll get exception as FileNotFoundException</h3>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,  new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},  1);

    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                        extract();
                } else {
                    Toast.makeText(MainActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

        }
    }
    
    
    
MIT License

Copyright (c) 2017 Ankit Dubey

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
