package com.company.M2ChallengeKhanSaqueb.controller;

import com.company.M2ChallengeKhanSaqueb.models.MathEquation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

@RestController
public class MathConverterController extends MathEquation {

    private static List<MathEquation> mathList = new ArrayList<>();
    private static int mathSolution;
    private static String mathProblem;

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public @Valid MathEquation createAdd(@RequestBody @Valid MathEquation MathEquation){

        mathSolution = sum(MathEquation.getOperand1(), MathEquation.getOperand2());
        mathProblem = "Addition";

        MathEquation.setAnswer(mathSolution);
        MathEquation.setOperator(mathProblem);
        mathList.add(MathEquation);

        return MathEquation;
    }


    @PostMapping(value = "/subtract")
    @ResponseStatus(value = HttpStatus.CREATED)
    public @Valid MathEquation createSubtract(@RequestBody @Valid MathEquation MathEquation){

        mathSolution = Math.subtractExact(MathEquation.getOperand1(), MathEquation.getOperand2());
        mathProblem = "Subtraction";

        MathEquation.setAnswer(mathSolution);
        MathEquation.setOperator(mathProblem);
        mathList.add(MathEquation);

        return MathEquation;
    }


    @PostMapping(value = "/multiply")
    @ResponseStatus(value = HttpStatus.CREATED)
    public @Valid MathEquation createMultiply(@RequestBody @Valid MathEquation MathEquation){

        mathSolution = Math.multiplyExact(MathEquation.getOperand1(), MathEquation.getOperand2());
        mathProblem = "Multiply";

        MathEquation.setAnswer(mathSolution);
        MathEquation.setOperator(mathProblem);
        mathList.add(MathEquation);

        return MathEquation;
    }

    @PostMapping(value = "/divide")
    @ResponseStatus(value = HttpStatus.CREATED)
    public @Valid MathEquation createDivide(@RequestBody @Valid MathEquation MathEquation){

        mathSolution = Math.floorDiv(MathEquation.getOperand1(), MathEquation.getOperand2());
        mathProblem = "Divide";

        MathEquation.setAnswer(mathSolution);
        MathEquation.setOperator(mathProblem);
        mathList.add(MathEquation);

        return MathEquation;
    }



}
