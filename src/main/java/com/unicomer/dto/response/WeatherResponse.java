package com.unicomer.dto.response;

import java.util.List;

public class WeatherResponse {
    private Forecast forecast;

    // Getters and Setters
    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public static class Forecast {
        private List<ForecastDay> forecastday;

        public List<ForecastDay> getForecastday() {
            return forecastday;
        }

        public void setForecastday(List<ForecastDay> forecastday) {
            this.forecastday = forecastday;
        }

        public static class ForecastDay {
            private Day day;

            public Day getDay() {
                return day;
            }

            public void setDay(Day day) {
                this.day = day;
            }

            public static class Day {
                private double avgtemp_c;

                public double getAvgtemp_c() {
                    return avgtemp_c;
                }

                public void setAvgtemp_c(double avgtemp_c) {
                    this.avgtemp_c = avgtemp_c;
                }
            }
        }
    }
}
