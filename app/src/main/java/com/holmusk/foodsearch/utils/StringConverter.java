/*
 * @author Shivanand Darur
 * @version 1.0
 */
package com.holmusk.foodsearch.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class StringConverter implements Converter {
    @Override
    public Object fromBody(TypedInput typedInput, Type type)
            throws ConversionException {

        String text = null;
        try {
            text = fromStream(typedInput.in());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    @Override
    public TypedOutput toBody(Object o) {
        return null;
    }

    /**
     * Custom method to convert stream from request to string
     *
     * @param in
     * @return
     * @throws IOException
     */
    public static String fromStream(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }
}