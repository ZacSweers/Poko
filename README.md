# Extra Care
![](https://github.com/drewhamilton/ExtraCare/workflows/CI/badge.svg?branch=master)

> Using Kotlin types whose properties will change over time in public API requires extra care to
> maintain source and binary compatibility as well as an idiomatic API for each language.

— Jake Wharton,
  [Public API challenges in Kotlin](https://jakewharton.com/public-api-challenges-in-kotlin/)

Extra Care is a Kotlin compiler plugin that makes writing and maintaining data classes for public
APIs easy. Like with normal Kotlin data classes, all you have to do is provide members in your
class's constructor. Then give it the `@DataApi` annotation and enjoy the generated `toString`,
`equals`, and `hashCode`. (Builder class for Java consumers and DSL initializer for Kotlin consumers
to be added.)

Extra Care is a work in progress. It's not published as an artifact yet.

## Use
Mark your class as a `@DataApi class` instead of a `data class`:
```kotlin
@DataApi class Simple(
    val int: Int,
    val requiredString: String,
    val optionalString: String?
)
```

And enjoy the benefits of a readable `toString` and working `equals` and `hashCode`. Unlike normal
data classes, no `copy` or `componentN` functions are generated.

## To-do
* Publish to Maven Central
* Make the repo public
* Handle arrays in `equals`?
* Generate the inner Builder class
* Propagate the constructor default values to the Builder 
* Mark the constructor as private
* Generate the top-level DSL initializer
* Add robust testing
* Add robust compiler messages for unsupported cases
* Write an IDE plugin?
* Multiplatform support?
* Support builders with a parameter, and default values of a different type, so I can write a class
  with `R.string` defaults for Strings and resolve them with a `Context` in the builder

## License
```
Copyright 2020 Drew Hamilton

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```