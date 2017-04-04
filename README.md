# wicket-spring-bean-issue
Problem with `@SpringBean` annotation on stateless pages

1. Run ExampleApplication with Spring Boot
2. Submit any text in the form
3. You should get a NullPointerException in the class `HomePageHandler` when trying to use bean `CommandPublisher` injected with `@Autowired` annotation.

### Expected behavior

`HomePageHandler` should call `CommandPublisher` with submitted name and redirect to `SecondPage` to display "Hello <name>" label.

But when `HomePage` becomes statefull (`SatelessForm` replaced with `Form` and removed `StatelessChecker` annotation) everything starts to work as expected.
