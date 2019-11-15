package id.qoisabd.moviecataloguesub1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int image;
    private String title;
    private String description;
    private String dateRelease;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(String dateRelease) {
        this.dateRelease = dateRelease;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.image);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.dateRelease);
    }

    public Movie() {

    }


    private Movie(Parcel in) {
        this.image = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
        this.dateRelease = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
