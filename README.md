# ExtractionLib [![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)
If you want to extract your jar file which is stored in your mobile internal storage, you don't have need to worry anymore, a lot of code is already there in library.
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
        
        
        <br>
        <br>
        for any query, you can mail me at -> ankitdubey021@gmail.com
    }
