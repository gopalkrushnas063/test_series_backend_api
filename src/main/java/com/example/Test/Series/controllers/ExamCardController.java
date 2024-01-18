package com.example.Test.Series.controllers;

import com.example.Test.Series.entity.ExamsCard;
import com.example.Test.Series.exceptions.ExamCardExceptions;
import com.example.Test.Series.services.ExamRepositoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/examcard")
public class ExamCardController {

    @Autowired
    private ExamRepositoryServices examRepositoryServices;

    @PostMapping("/add_exam_card")
    public ResponseEntity<ExamsCard> addNewExamCardHandler(@RequestBody ExamsCard examsCard) throws ExamCardExceptions {
        ExamsCard examsCard1 = examRepositoryServices.addExamCard(examsCard);
        return new ResponseEntity<>(examsCard1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/all_exam_card")
    public ResponseEntity<List<ExamsCard>> getAllExamCardListHandler() throws ExamCardExceptions{
        List<ExamsCard> examsCardList = examRepositoryServices.getAllExamCardList();
        return new ResponseEntity<>(examsCardList,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamsCard> updateExamCArdByIDHandler(@PathVariable("id") Integer id, ExamsCard examsCard) throws ExamCardExceptions {
        ExamsCard examsCard1 = examRepositoryServices.updateExamCardByID(id,examsCard);
        return new ResponseEntity<>(examsCard, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExamCardByIDHandler(@PathVariable("id") Integer id) throws ExamCardExceptions{
        String res = examRepositoryServices.deleteExamCardByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
