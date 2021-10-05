
# Modern onboarding library

#### Story of creation
I was building an app that requires some introduction. So I created an activity for app walkthrough or you can say onboarding screen. I want the same activity
for other app too. Not a big deal, I could copy & paste the code but, I everytime have to make changes to it according to the app. So I thought why not to build an android library which can be used by everyone everywhere despite of making changes to an existing class. This will save a large fraction of time of many developers - and this is what my moto is.

*My moto - "Make developers life easier"*





## Implimentation

In your project ```build.gradle``` (root of project)

```groovy
 allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
In your module ```build.gradle``` (usually in app)
```groovy
dependencies {
	        implementation 'com.github.ErrorxCode:ModernOnboarding:1.0.0'
	}
```

  
## Usage
First create an activity for Onboarding screen, this activity does not need to have a layout.

```java
public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main)  ---> Remove this line
        
}

```
Then create a list of `OnBoardingPage` passing an image, a title and a description as an argument.
```java
List<OnBoardingPage> pages = new ArrayList<>();
pages.add(new OnBoardingPage(R.drawable.image1,"Title for page 1 goes here....","Description for page 1 goes here...."));
pages.add(new OnBoardingPage(R.drawable.image2,"Title for page 2 goes here....","Description for page 2 goes here...."));
pages.add(new OnBoardingPage(R.drawable.image3,"Title for page 3 goes here....","Description for page 3 goes here...."));
```
**Note : You must have minimum of 3 pages & maximum of 6 as per material design guidlines**

You can also use its second constructor, which also takes `bgColor, txtColor` as an argument, if you want to customise the page.
```java
new OnBoardingPage(R.drawable.sound_wave, Color.BLACK,Color.WHITE,"title here..","description here...");
```

Finally, pass that list to `OnBoarder.startOnBoarding()`. You can also pass null as 3rd argument.
```java
OnBoarder.startOnBoarding(this, pages, new OnFinishLastPage() {
            @Override
            public void onNext() {
                // this is called when user click finish button on last page.
            }
        });
```
Use shared preference to show onboarding screen only one time.

**Full example**

Main activity :
```java
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);
        if (!pref.getBoolean("welcomed",false)){
            startActivity(new Intent(this,OnBoardingActivity.class));
            pref.edit().putBoolean("welcomed",true).apply();
        }
    }
 }

```
OnBoarding activity :
```java
public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main)  ---> Remove this line
        List<OnBoardingPage> pages = new ArrayList<>();
        pages.add(new OnBoardingPage(R.drawable.image1,"Title for page 1 goes here....","Description for page 1 goes here...."));
        pages.add(new OnBoardingPage(R.drawable.image2,"Title for page 2 goes here....","Description for page 2 goes here...."));
        pages.add(new OnBoardingPage(R.drawable.image3,"Title for page 3 goes here....","Description for page 3 goes here...."));
        
        OnBoarder.startOnBoarding(this, pages,null);
    }
}
```

**Watch the whole tutorial & demo here** : 

## Suport us
Support me to keep this library alive. If you like my hard work, please give this repo a star 🌟 & Nothing else. Also check my other repos. Thank you ! .

## License 
```

```
