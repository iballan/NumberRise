NumberRiseTextView
==============

[![](https://jitpack.io/v/iballan/RateDialog.svg)](https://jitpack.io/#iballan/RateDialog)

## RateDialog will allow you to prompt a message to users helping them to Rate you app

Screenshots:
--------


Usage :

XML Layout:
``` xml
<com.mbh.numberrise.NumberRiseTextView
	android:id="@+id/tv_numberRise"
	android:text="0"
	android:gravity="center"
	android:layout_width="match_parent"
	android:layout_height="wrap_content"
	android:textSize="40sp"/>
```

Java:
``` java

// variable in the activity
NumberRiseTextView tv_1;
.
.
.
// later on in OnCreate function
tv_1 = (NumberRiseTextView) findViewById(R.id.tv_1);

tv_1.setDuration(5000/*animation duration in milliseconds */).animate(0, 10); // animate(from, to); both integer and float works

```

Install
--------

You can install using Gradle:

```gradle
	repositories {
	    maven { url "https://jitpack.io" }
	}
	dependencies {
	    compile 'com.github.iballan:numberrise:0.0.1'
	}
```

Contact me:
--------

Twitter: [@mbh01t](https://twitter.com/mbh01t)

Github: [iballan](https://github.com/iballan)

Website: [www.mbh01.com](http://mbh01.com)

Credits:
--------

....


License
--------

    Copyright 2016 Mohamad Ballan.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.