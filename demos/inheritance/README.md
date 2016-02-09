# Mungo inheritance example

This illustrates several of the features of inheritance that we will
need to support in Mungo, and the potential interaction with typestate.
The `extends` is currently commented out as it is not yet supported.
Also, typestate fields must currently must be `private`; these will need
to be redeclared as `protected` when this is permitted. We will make it
an error to access a `protected` field other than from a subclass.

## Notes

* `LoggedFile` extends `File`
* The purpose of `LogService` and `FileHandle` is to serve as the type
  of fields whose typestate must be checked as part of checking the
  containing class.
* `File.open` makes a self call to `read`. This will call the
  _overridden_ version of `read` in `LoggedFile`, which must be taken
  into account when checking the `logging` typestate field of
  `LoggedFile`.
* `LoggedFile` calls `super` methods in order to extend their behaviour
  with logging (or will, once it is able to extend `File`). In
  particular it attempts to call `super.open` before `logging.start`.
  This should be a compile-time error, because `log` will end up being
  called, via `read`, on a logging service which has not been started.
