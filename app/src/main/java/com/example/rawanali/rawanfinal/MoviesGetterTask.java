package com.example.rawanali.rawanfinal;



import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rawan Ali on 9/5/2017.
 */

public abstract class MoviesGetterTask extends AsyncTask<Void, Void, List<image>> {


        @Override
        protected List<image> doInBackground(Void... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(
                        "https://api.themoviedb.org/3/movie/popular?api_key=be1f8a35b0e7e4b3be7c1ce2b1e8cab8"
                );

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();
                StringBuilder buffer = new StringBuilder();
                if (inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(String.format("%s\n", line));
                }

                if (buffer.length() == 0) {
                    return null;
                }

                String response = buffer.toString();

                List<image> movies = parseMovies(response);

                return movies;


            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {

                    }
                }
            }
        }

        private List<image> parseMovies(String response) throws Exception {
            List<image> movies = new ArrayList<>();
            JSONObject rootObject = new JSONObject(response);
            JSONArray moviesJsonArray = rootObject.getJSONArray("results");
            for (int i = 0; i < moviesJsonArray.length(); i++) {
                JSONObject movieJsonObject = moviesJsonArray.getJSONObject(i);
                image movie = new image();
                movie.setBackDropUrl("http://image.tmdb.org/t/p/w780/" + movieJsonObject.getString("backdrop_path"));
                movie.setName(movieJsonObject.getString("title"));
                movie.setDate(movieJsonObject.getString("release_date"));
                movie.setRate(movieJsonObject.getDouble("vote_average"));
                movie.setNumOfVoters(movieJsonObject.getInt("vote_count"));
                movie.setDescription(movieJsonObject.getString("overview"));
                movie.setImageUrl("http://image.tmdb.org/t/p/w780/" + movieJsonObject.getString("poster_path"));
                movie.setName(movieJsonObject.getString("title"));
                movies.add(movie);
            }
            return movies;
        }

        @Override
        protected abstract void onPostExecute(List<image> movies);
    }

