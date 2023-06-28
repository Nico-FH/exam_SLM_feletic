package com.example.exam_feletic.modify;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class StringModify {
    private static String message;
    private static int lastLength = 0;

    @GetMapping("/modify")
    public String ModifyString(String string){
        StringBuilder modifiedString = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);

            if (i % 2 == 1) {
                // Convert every second character to uppercase
                currentChar = Character.toUpperCase(currentChar);
            }

            modifiedString.append(currentChar);
        }
        message = modifiedString.toString();

        lastLength = message.length();
        return message;
    }

    @GetMapping("/length")
    public int getLastLength(){
        return lastLength;
    }
}
