package com.application.signatures.jackson.service;

import com.application.signatures.jackson.entity.DocumentXml;
import com.application.signatures.jackson.entity.LevelXml;
import com.application.signatures.jackson.entity.Sign;
import com.application.signatures.jackson.parser.XmlParser;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.stream.Collectors;

@Service
public class XmlService {

    public static   DocumentXml getDocument(File file){
        return XmlParser.xmlToObject(file);
    }

    public void setSign(String fileName, String level, String login, Boolean sign){
        DocumentXml documentXml = getDocument(new File(fileName));
        LevelXml currentLevel = documentXml.getLevelXmls().stream().filter(it -> it.getName().equals(level)).collect(Collectors.toList()).get(0);
        Sign currentSign = currentLevel.getUserSign().stream().filter(it -> it.getLogin().equals(login)).collect(Collectors.toList()).get(0);
        currentSign.setSign(sign);
        saveDocument(fileName, documentXml);
    }

    public static void saveDocument(String filename, DocumentXml document){
        XmlParser.objectToXml(filename, document);
    }
}
