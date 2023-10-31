package racingcar.model;

import java.util.List;

public class Race {
    private int numberOfRace;
    private final static String TOO_MUCH_NUMBER_OF_RACE = "너무 많은 회수를 입력하였습니다.";
    private final static int REFERENCE_NUMBER = 4;

    private Race(final int numberOfRace) {
        validateNumberOfRace(numberOfRace);
        this.numberOfRace = numberOfRace;
    }

    public static Race from(final int numberOfRace) {
        return new Race(numberOfRace);
    }

    private void validateNumberOfRace(final int numberOfRace) {
        if (numberOfRace > 100) {
            throw new IllegalArgumentException(TOO_MUCH_NUMBER_OF_RACE);
        }
    }

    public void runSingleRace(final List<Car> cars) {
        cars.stream()
                .filter(car -> Generator.generateRandomNumber() >= REFERENCE_NUMBER)
                .forEach(Car::moveForward);
        this.numberOfRace--;
    }

    public final boolean isRunning() {
        return this.numberOfRace > 0;
    }
}
