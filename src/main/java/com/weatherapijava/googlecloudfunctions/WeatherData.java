package com.weatherapijava.googlecloudfunctions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

final class Coord {
    private double lon;
    private double lat;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "{" +
                "\"lon\":" + lon +
                ", \"lat\":" + lat +
                '}';
    }
}

final class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"main\":\"" + main + '\"' +
                ", \"description\":\"" + description + '\"' +
                ", \"icon\":\"" + icon + '\"' +
                '}';
    }
}

final class Main {
    private double temp;
    @JsonProperty("feels_like")

    private double feelsLike;
    @JsonProperty("temp_min")

    private double tempMin;
    @JsonProperty("temp_max")

    private double tempMax;
    private int pressure;
    private int humidity;
    @JsonProperty("sea_level")

    private int seaLevel;
    @JsonProperty("grnd_level")

    private int grndLevel;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    public int getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(int grndLevel) {
        this.grndLevel = grndLevel;
    }

    @Override
    public String toString() {
        return "{" +
                "\"temp\":" + temp +
                ", \"feels_like\":" + feelsLike +
                ", \"temp_min\":" + tempMin +
                ", \"temp_max\":" + tempMax +
                ", \"pressure\":" + pressure +
                ", \"humidity\":" + humidity +
                ", \"sea_level\":" + seaLevel +
                ", \"grnd_level\":" + grndLevel +
                '}';
    }
}


final class Wind {
    private double speed;
    private int deg;
    private double gust;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public double getGust() {
        return gust;
    }

    public void setGust(double gust) {
        this.gust = gust;
    }

    @Override
    public String toString() {
        return "{" +
                "\"speed\":" + speed +
                ", \"deg\":" + deg +
                ", \"gust\":" + gust +
                '}';
    }
}

final class Rain {
    @JsonProperty("1h")

    private double oneHour;

    public double getOneHour() {
        return oneHour;
    }

    public void setOneHour(double oneHour) {
        this.oneHour = oneHour;
    }

    @Override
    public String toString() {
        return "{" +
                "\"1h\":" + oneHour +
                '}';
    }
}

final class Clouds {
    private int all;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "{" +
                "\"all\":" + all +
                '}';
    }
}

final class Sys {
    private int type;
    private int id;
    private String country;
    private int sunrise;
    private int sunset;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "{" +
                "\"type\":" + type +
                ", \"id\":" + id +
                ", \"country\":\"" + country + '\"' +
                ", \"sunrise\":" + sunrise +
                ", \"sunset\":" + sunset +
                '}';
    }
}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class WeatherData implements Serializable{
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "{" +
                "\"coord\":" + this.coord +
                ", \"weather\":" + this.weather +
                ", \"base\":\"" + this.base + '\"' +
                ", \"main\":" + this.main +
                ", \"visibility\":" + this.visibility +
                ", \"wind\":" + this.wind +
                ", \"rain\":" + this.rain +
                ", \"clouds\":" + this.clouds +
                ", \"dt\":" + this.dt +
                ", \"sys\":" + this.sys +
                ", \"timezone\":" + this.timezone +
                ", \"id\":" + this.id +
                ", \"name\":\"" + this.name + '\"' +
                ", \"cod\":" + this.cod +
                '}';
    }
}