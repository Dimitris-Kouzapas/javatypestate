# Mungo inheritance example

This illustrates several of the features of inheritance that we will
need to support in Mungo and the interaction with typestate.



## Notes

* `extends` is currently commented out as not supported
* Typestate fields currently must be `private`, but will need to be
  `protected`. We will make it an error to access a `protected' field
  other than from a subclass.
* `LoggedFile` extends `File`
* `LogService` and `FileHandle` are
