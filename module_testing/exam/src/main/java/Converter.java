class Converter {
    static int toCelsius(int fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    static int toFahrenheit(int celsius) {
        return celsius * 9 / 5 + 32;
    }
}