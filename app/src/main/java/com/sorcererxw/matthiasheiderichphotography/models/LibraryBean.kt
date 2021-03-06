package com.sorcererxw.matthiasheiderichphotography.models

/**
 * @description:
 * @author: Sorcerer
 * @date: 2016/8/25
 */
class LibraryBean(
        var name: String?,
        var author: String?,
        var license: String?,
        var link: String?,
        var describe: String?
) {
    companion object {

        val LIBRARY_BEEN = arrayOf(LibraryBean(
                "RxAndroid",
                "ReactiveX",
                "Copyright 2015 The RxAndroid authors\n"
                        + "\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                        + "you may not use this file except in compliance with the License.\n"
                        + "You may obtain a copy of the License at\n"
                        + "\n"
                        + "    http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "\n"
                        + "Unless required by applicable law or agreed to in writing, software\n"
                        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                        + "See the License for the specific language governing permissions and\n"
                        + "limitations under the License.", // licence
                "https://github.com/ReactiveX/RxAndroid", // link
                "RxJava bindings for Android"  // des
        ), LibraryBean(
                "RxJava", // name
                "ReactiveX", // author
                "Copyright 2013 Netflix, Inc.\n"
                        + "\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\"); you may not use this file except in compliance with the License. You may obtain a copy of the License at\n"
                        + "\n"
                        + "http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "\n"
                        + "Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an \"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.",
                // licence
                "https://github.com/ReactiveX/RxJava", // link
                "RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM."
                // des
        ), LibraryBean(
                "glide", // name
                "bumptech", // author
                "License for everything not in third_party and not otherwise marked:\n"
                        + "\n"
                        + "Copyright 2014 Google, Inc. All rights reserved.\n"
                        + "\n"
                        + "Redistribution and use in source and binary forms, with or without modification, are\n"
                        + "permitted provided that the following conditions are met:\n"
                        + "\n"
                        + "   1. Redistributions of source code must retain the above copyright notice, this list of\n"
                        + "         conditions and the following disclaimer.\n"
                        + "\n"
                        + "   2. Redistributions in binary form must reproduce the above copyright notice, this list\n"
                        + "         of conditions and the following disclaimer in the documentation and/or other materials\n"
                        + "         provided with the distribution.\n"
                        + "\n"
                        + "THIS SOFTWARE IS PROVIDED BY GOOGLE, INC. ``AS IS'' AND ANY EXPRESS OR IMPLIED\n"
                        + "WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND\n"
                        + "FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL GOOGLE, INC. OR\n"
                        + "CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR\n"
                        + "CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR\n"
                        + "SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON\n"
                        + "ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING\n"
                        + "NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF\n"
                        + "ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.\n"
                        + "\n"
                        + "The views and conclusions contained in the software and documentation are those of the\n"
                        + "authors and should not be interpreted as representing official policies, either expressed\n"
                        + "or implied, of Google, Inc.\n"
                        + "---------------------------------------------------------------------------------------------\n"
                        + "License for third_party/disklrucache:\n"
                        + "\n"
                        + "Copyright 2012 Jake Wharton\n"
                        + "Copyright 2011 The Android Open Source Project\n"
                        + "\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                        + "you may not use this file except in compliance with the License.\n"
                        + "You may obtain a copy of the License at\n"
                        + "\n"
                        + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "\n"
                        + "Unless required by applicable law or agreed to in writing, software\n"
                        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                        + "See the License for the specific language governing permissions and\n"
                        + "limitations under the License.\n"
                        + "---------------------------------------------------------------------------------------------\n"
                        + "License for third_party/gif_decoder:\n"
                        + "\n"
                        + "Copyright (c) 2013 Xcellent Creations, Inc.\n"
                        + "\n"
                        + "Permission is hereby granted, free of charge, to any person obtaining\n"
                        + "a copy of this software and associated documentation files (the\n"
                        + "\"Software\"), to deal in the Software without restriction, including\n"
                        + "without limitation the rights to use, copy, modify, merge, publish,\n"
                        + "distribute, sublicense, and/or sell copies of the Software, and to\n"
                        + "permit persons to whom the Software is furnished to do so, subject to\n"
                        + "the following conditions:\n"
                        + "\n"
                        + "The above copyright notice and this permission notice shall be\n"
                        + "included in all copies or substantial portions of the Software.\n"
                        + "\n"
                        + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND,\n"
                        + "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF\n"
                        + "MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND\n"
                        + "NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE\n"
                        + "LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION\n"
                        + "OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION\n"
                        + "WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.\n"
                        + "---------------------------------------------------------------------------------------------\n"
                        + "License for third_party/gif_encoder/AnimatedGifEncoder.java and\n"
                        + "third_party/gif_encoder/LZWEncoder.java:\n"
                        + "\n"
                        + "No copyright asserted on the source code of this class. May be used for any\n"
                        + "purpose, however, refer to the Unisys LZW patent for restrictions on use of\n"
                        + "the associated LZWEncoder class. Please forward any corrections to\n"
                        + "kweiner@fmsware.com.\n"
                        + "\n"
                        + "-----------------------------------------------------------------------------\n"
                        + "License for third_party/gif_encoder/NeuQuant.java\n"
                        + "\n"
                        + "Copyright (c) 1994 Anthony Dekker\n"
                        + "\n"
                        + "NEUQUANT Neural-Net quantization algorithm by Anthony Dekker, 1994. See\n"
                        + "\"Kohonen neural networks for optimal colour quantization\" in \"Network:\n"
                        + "Computation in Neural Systems\" Vol. 5 (1994) pp 351-367. for a discussion of\n"
                        + "the algorithm.\n"
                        + "\n"
                        + "Any party obtaining a copy of these files from the author, directly or\n"
                        + "indirectly, is granted, free of charge, a full and unrestricted irrevocable,\n"
                        + "world-wide, paid up, royalty-free, nonexclusive right and license to deal in\n"
                        + "this software and documentation files (the \"Software\"), including without\n"
                        + "limitation the rights to use, copy, modify, merge, publish, distribute,\n"
                        + "sublicense, and/or sell copies of the Software, and to permit persons who\n"
                        + "receive copies from any such party to do so, with the only requirement being\n"
                        + "that this copyright notice remain intact.", // licence
                "https://github.com/bumptech/glide", // link
                "An image loading and caching library for Android focused on smooth scrolling"
                // des
        ), LibraryBean(
                "butterknife", // name
                "JakeWharton", // author
                "Copyright 2013 Jake Wharton\n"
                        + "\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                        + "you may not use this file except in compliance with the License.\n"
                        + "You may obtain a copy of the License at\n"
                        + "\n"
                        + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "\n"
                        + "Unless required by applicable law or agreed to in writing, software\n"
                        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                        + "See the License for the specific language governing permissions and\n"
                        + "limitations under the License.\n", // licence
                "https://github.com/JakeWharton/butterknife", // link
                "Bind Android views and callbacks to fields and methods."  // des
        ), LibraryBean(
                "AVLoadingIndicatorView", // name
                "81813780", // author
                "Copyright 2015 jack wang\n"
                        + "\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                        + "you may not use this file except in compliance with the License.\n"
                        + "You may obtain a copy of the License at\n"
                        + "\n"
                        + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "\n"
                        + "Unless required by applicable law or agreed to in writing, software\n"
                        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                        + "See the License for the specific language governing permissions and\n"
                        + "limitations under the License.", // licence
                "https://github.com/81813780/AVLoadingIndicatorView", // link
                "Nice loading animations for Android"  // des
        ), LibraryBean(
                "Android-Iconics", // name
                "mikepenz", // author
                "Copyright 2016 Mike Penz\n"
                        + "\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                        + "you may not use this file except in compliance with the License.\n"
                        + "You may obtain a copy of the License at\n"
                        + "\n"
                        + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "\n"
                        + "Unless required by applicable law or agreed to in writing, software\n"
                        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                        + "See the License for the specific language governing permissions and\n"
                        + "limitations under the License.", // licence
                "https://github.com/mikepenz/Android-Iconics", // link
                "Android-Iconics - Use any icon font, or vector (.svg) as drawable in your application."),
                LibraryBean(
                        "MaterialDrawer",
                        "mikepenz",
                        "Copyright 2016 Mike Penz\n"
                                + "\n"
                                + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                                + "you may not use this file except in compliance with the License.\n"
                                + "You may obtain a copy of the License at\n"
                                + "\n"
                                + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                                + "\n"
                                + "Unless required by applicable law or agreed to in writing, software\n"
                                + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                                + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                                + "See the License for the specific language governing permissions and\n"
                                + "limitations under the License.",
                        "https://github.com/mikepenz/MaterialDrawer",
                        "The flexible, easy to use, all in one drawer library for your Android project."),
                LibraryBean(
                        "material-dialogs",
                        "afollestad",
                        "The MIT License (MIT)\n"
                                + "\n"
                                + "Copyright (c) 2014-2016 Aidan Michael Follestad\n"
                                + "\n"
                                + "Permission is hereby granted, free of charge, to any person obtaining a copy\n"
                                + "of this software and associated documentation files (the \"Software\"), to deal\n"
                                + "in the Software without restriction, including without limitation the rights\n"
                                + "to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n"
                                + "copies of the Software, and to permit persons to whom the Software is\n"
                                + "furnished to do so, subject to the following conditions:\n"
                                + "\n"
                                + "The above copyright notice and this permission notice shall be included in all\n"
                                + "copies or substantial portions of the Software.\n"
                                + "\n"
                                + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n"
                                + "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n"
                                + "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n"
                                + "AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n"
                                + "LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n"
                                + "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE\n"
                                + "SOFTWARE.",
                        "https://github.com/afollestad/material-dialogs",
                        "A beautiful, fluid, and customizable dialogs API. "), LibraryBean(
                "FloatingActionButton", // name
                "Clans", // author
                "Copyright 2015 Dmytro Tarianyk\n"
                        + "\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                        + "you may not use this file except in compliance with the License.\n"
                        + "You may obtain a copy of the License at\n"
                        + "\n"
                        + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "\n"
                        + "Unless required by applicable law or agreed to in writing, software\n"
                        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                        + "See the License for the specific language governing permissions and\n"
                        + "limitations under the License.", // licence
                "https://github.com/Clans/FloatingActionButton", // link
                "Android Floating Action Button based on Material Design specification\n"
                // des
        ), LibraryBean(
                "PhotoView",
                "chrisbanes",
                "Copyright 2011, 2012 Chris Banes\n"
                        + "\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                        + "you may not use this file except in compliance with the License.\n"
                        + "You may obtain a copy of the License at\n"
                        + "\n"
                        + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "\n"
                        + "Unless required by applicable law or agreed to in writing, software\n"
                        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                        + "See the License for the specific language governing permissions and\n"
                        + "limitations under the License.",
                "https://github.com/chrisbanes/PhotoView",
                "Implementation of ImageView for Android that supports zooming, by various touch gestures."
        ), LibraryBean(
                "muzei",
                "romannurik",
                "Copyright 2014 Google Inc.\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                        + "you may not use this file except in compliance with the License.\n"
                        + "You may obtain a copy of the License at\n"
                        + "    http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "Unless required by applicable law or agreed to in writing, software\n"
                        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                        + "See the License for the specific language governing permissions and\n"
                        + "limitations under the License.",
                "https://github.com/romannurik/muzei",
                "Muzei Live Wallpaper for Android"), LibraryBean(
                "android-pathview",
                "geftimov",
                "Copyright 2016 Georgi Eftimov\n"
                        + "\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                        + "you may not use this file except in compliance with the License.\n"
                        + "You may obtain a copy of the License at\n"
                        + "\n"
                        + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "\n"
                        + "Unless required by applicable law or agreed to in writing, software\n"
                        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                        + "See the License for the specific language governing permissions and\n"
                        + "limitations under the License.",
                "https://github.com/geftimov/android-pathview",
                "Android view with both path from constructed path or from svg."), LibraryBean(
                "sqlbrite",
                "square",
                "Copyright 2015 Square, Inc.\n"
                        + "\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                        + "you may not use this file except in compliance with the License.\n"
                        + "You may obtain a copy of the License at\n"
                        + "\n"
                        + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "\n"
                        + "Unless required by applicable law or agreed to in writing, software\n"
                        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                        + "See the License for the specific language governing permissions and\n"
                        + "limitations under the License.",
                "https://github.com/square/sqlbrite",
                "A lightweight wrapper around SQLiteOpenHelper which introduces reactive stream semantics to SQL operations."),
                LibraryBean(
                        "timber",
                        "JakeWharton",
                        "Copyright 2013 Jake Wharton\n"
                                + "\n"
                                + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                                + "you may not use this file except in compliance with the License.\n"
                                + "You may obtain a copy of the License at\n"
                                + "\n"
                                + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                                + "\n"
                                + "Unless required by applicable law or agreed to in writing, software\n"
                                + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                                + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                                + "See the License for the specific language governing permissions and\n"
                                + "limitations under the License.",
                        "https://github.com/JakeWharton/timber",
                        "A logger with a small, extensible API which provides utility on top of Android's normal Log class."),
                LibraryBean(
                        "auto",
                        "google",
                        "Copyright 2013 Google, Inc.\n"
                                + "\n"
                                + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                                + "you may not use this file except in compliance with the License.\n"
                                + "You may obtain a copy of the License at\n"
                                + "\n"
                                + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                                + "\n"
                                + "Unless required by applicable law or agreed to in writing, software\n"
                                + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                                + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                                + "See the License for the specific language governing permissions and\n"
                                + "limitations under the License.",
                        "https://github.com/google/auto",
                        "A collection of source code generators for Java."), LibraryBean(
                "auto-value-parcel",
                "rharter",
                "Copyright 2015 Ryan Harter.\n"
                        + "\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                        + "you may not use this file except in compliance with the License.\n"
                        + "You may obtain a copy of the License at\n"
                        + "\n"
                        + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "\n"
                        + "Unless required by applicable law or agreed to in writing, software\n"
                        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                        + "See the License for the specific language governing permissions and\n"
                        + "limitations under the License.",
                "https://github.com/rharter/auto-value-parcel",
                "An Android Parcelable extension for Google's AutoValue."),
                LibraryBean("jsoup", "Jonathan Hedley",
                        "The MIT License\n"
                                + "Copyright © 2009 - 2016 Jonathan Hedley (jonathan@hedley.net)\n"
                                + "\n"
                                + "Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the \"Software\"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:\n"
                                + "\n"
                                + "The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.\n"
                                + "\n"
                                + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.",
                        "https://jsoup.org/",
                        "parse, manipulate, and clean real-world HTML"),
                LibraryBean("dagger", "google", "Copyright 2012 The Dagger Authors\n"
                        + "\n"
                        + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                        + "you may not use this file except in compliance with the License.\n"
                        + "You may obtain a copy of the License at\n"
                        + "\n"
                        + "   http://www.apache.org/licenses/LICENSE-2.0\n"
                        + "\n"
                        + "Unless required by applicable law or agreed to in writing, software\n"
                        + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                        + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                        + "See the License for the specific language governing permissions and\n"
                        + "limitations under the License.",
                        "https://github.com/google/dagger",
                        "A fast dependency injector for Android and Java."))
    }
}
