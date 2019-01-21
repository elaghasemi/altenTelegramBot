package learnswedish.service;

import learnswedish.domain.Lesson;
import learnswedish.domain.SwedishWord;
import learnswedish.repository.LessonRepository;
import learnswedish.repository.UserRepository;
import learnswedish.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitiateService {
    @Autowired
    private WordRepository wordRepository;


    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private UserRepository userRepository;

    public void fillTheWords() {
        wordRepository.deleteAll();
        lessonRepository.deleteAll();
        userRepository.deleteAll();

//        List<SwedishWord> greetingsList = new ArrayList<>();
//        List<SwedishWord> verbsList = new ArrayList<>();
//
//        SwedishWord hi = new SwedishWord("1", "Hej", "Hi");
//        greetingsList.add(wordRepository.save(hi));
//
//        SwedishWord goodBye = new SwedishWord("2", "Hej då", "Goodbye");
//        greetingsList.add(wordRepository.save(goodBye));
//
//        Lesson lesson1 = new Lesson("1", "Greetings", greetingsList);
//        lessonRepository.save(lesson1);
//
//        SwedishWord make = new SwedishWord("3", "göra", "make");
//        verbsList.add(wordRepository.save(make));
//
//        SwedishWord laugh = new SwedishWord("4", "skratta", "laugh");
//        verbsList.add(wordRepository.save(laugh));
//
//        SwedishWord come = new SwedishWord("5", "komma", "come");
//        verbsList.add(wordRepository.save(come));
//
//        Lesson lesson2 = new Lesson("2", "Common Verbs", verbsList);
//        lessonRepository.save(lesson2);

       addLesson1();
       addLesson2();
       addLesson3();

    }

    private  void addLesson1(){
        List<SwedishWord> list = new ArrayList<>();
        saveWord(list, new SwedishWord("1", "Hej", "Hi"));
        saveWord(list, new SwedishWord("2", "Hej då", "Goodbye"));
        lessonRepository.save(new Lesson("1","Greetings",list));
    }

    private  void addLesson2(){
        List<SwedishWord> list = new ArrayList<>();
        saveWord(list,new SwedishWord("3", "göra", "make"));
        saveWord(list, new SwedishWord("4", "skratta", "laugh"));
        saveWord(list,new SwedishWord("5", "komma", "come"));
        lessonRepository.save(new Lesson("2","Common Verbs",list));
    }

    private  void addLesson3(){
        List<SwedishWord> list = new ArrayList<>();
        saveWord(list,new SwedishWord("6","timme","hour"));
        saveWord(list,new SwedishWord("7","sekund","second"));
        saveWord(list,new SwedishWord("8","Kalender","calendar"));
        saveWord(list,new SwedishWord("9","igår","yesterday"));
        saveWord(list,new SwedishWord("10","imorgon","tomorrow"));
        saveWord(list,new SwedishWord("11","idag","today"));
        saveWord(list,new SwedishWord("12","år","year"));
        lessonRepository.save(new Lesson("3","Day and Timing",list));
    }

    private  void saveWord(List<SwedishWord> list ,SwedishWord swedishWord){
        list.add(wordRepository.save(swedishWord));
    }
}
