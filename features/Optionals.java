import java.util.Optional;

public class Optionals {
    public static void main(String... args) {
        Optional<Car> optCar = Optional.empty();
        Optional<Car> optCar = Optional.of(car);
        Optional<Car> optCar = Optional.ofNullable(car);
        Optional<String> name = optInsurance.map(Insurance::getName);

        Optional<Person> optPerson = Optional.of(person);
        public String getCarInsuranceName(Optional<Person> person) {
            return person.flatMap(Person::getCar)
                    .flatMap(Car::getInsurance)
                    .map(Insurance::getName)
                    .orElse("Unknown");              1
        }

        public Set<String> getCarInsuranceNames(List<Person> persons) {
            return persons.stream()
                    .map(Person::getCar)                                  //getCar returns optional
                    .map(optCar -> optCar.flatMap(Car::getInsurance))
                    .map(optIns -> optIns.map(Insurance::getName))
                    .flatMap(Optional::stream)
                    .collect(toSet());
        }

        Set<String> result = stream.filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toSet());

        optional.stream().doTheComputation();
        //combine two optionals
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c));

        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
                .orElse("Unknown");

                Optional<Object> value = Optional.ofNullable(map.get("key"));

        public static Optional<Integer> stringToInt(String s) {
            try {
                return Optional.of(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        }

        public int readDuration(Properties props, String name) {
            return Optional.ofNullable(props.getProperty(name))
                    .flatMap(OptionalUtility::stringToInt)
                    .filter(i -> i > 0)
                    .orElse(0);
        }



    }
}
