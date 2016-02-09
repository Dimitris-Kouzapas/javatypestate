# Mungo inheritance example

This illustrates several of the features of inheritance that we will
need to support in Mungo, and the potential interaction with typestate.
The `extends` keyword is currently commented out as it is not yet
supported. Moreover typestate fields must currently must be `private`;
these will need to be redeclared as `protected`, once this is
implemented. We will make it an error to access a `protected` field
other than from a subclass.

## Notes

* `LoggedFile` extends `File` to add logging/instrumentation to `File`
  methods.
* The purpose of `LogService` and `FileHandle` is to serve as the type
  of fields whose typestate must be checked as part of checking the
  containing class.
* `File.open` makes a self call to `read`. This will call the
  _overridden_ version of `read` in `LoggedFile`, which must be taken
  into account when checking the `logging` typestate field of
  `LoggedFile`.
* In particular, `LoggedFile.open` calls `super.open` _before_
  `logging.start`. This should be a compile-time error, because `log`
  will end up being called, via `read`, on an unstarted logging service.
