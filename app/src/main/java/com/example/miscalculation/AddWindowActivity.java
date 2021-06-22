package com.example.miscalculation;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import android.widget.Button;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class AddWindowActivity extends AppCompatActivity {

    static boolean addFromList = false;

    static boolean flag = false;
    static boolean balDorFlag = false;
    static boolean gluhFlag = false;
    static boolean getPriceFlag = false;
    static boolean BB6024 = false;
    static boolean BB6032 = false;
    static boolean salamander = false;


    static Spinner spinnerType = null;
    static Spinner spinnerProfile = null;
    static Spinner spinnerTypeOfGlass = null;
    static Spinner spinnerFurnit = null;
    static Spinner spinnerTypeOfType = null;
    static Spinner spinnerHight = null;
    static Spinner spinnerWidth = null;
    static Spinner spinnerLamination = null;
    static Spinner spinnerRegion = null;
    static Spinner spinnerShpros = null;
    static Spinner spinnerShprosWidth = null;
    static Spinner spinnerGlassDif = null;
    static Spinner spinnerFigure = null;
    static Spinner spinnerFilling = null;
    static Spinner spinnerHandle = null;
    static Spinner spinnerShtulp = null;

    static int positionType1;
    static int positionTypeOfType1;
    static int positionHight1;
    static int positionWidth1;
    static int positionFurnit1;
    static int positionProfile1;
    static int positionTypeOfGlass1;
    static int positionLamination1;
    static int positionRegion1;
    static int positionShpros1;
    static int positionShprosWidth1;
    static int positionGlassDif1;
    static int positionFigure1;
    static int positionFilling1;
    static int positionHandle1;
    static int positionShtulp1;


    static int price;
    static double furnitPrice;
    static int itemInterest;
    static double priceFigure;
    static double priceHandle;
    static int priceShtulp;

    static double profileCoefficient;
    static double laminationCoefficient;
    static double priceGlass;
    static double lam;
    static double shpros;

    static List<String> dataTypeOfType = new ArrayList<>();
    static List<String> dataTypeOfGlass = new ArrayList<>();
    static List<String> dataFurnit = new ArrayList<>();
    static List<String> dataLamination = new ArrayList<>();
    static List<String> dataRegion = new ArrayList<>();
    static List<String> dataProfile = new ArrayList<>();
    static List<String> dataHight = new ArrayList<>();
    static List<String> dataWidth = new ArrayList<>();
    static List<String> dataShpros = new ArrayList<>();
    static List<String> dataShprosWidth = new ArrayList<>();
    static List<String> dataGlassDif = new ArrayList<>();
    static List<String> dataGlassList = new ArrayList<>();
    static List<String> dataFigure = new ArrayList<>();
    static List<String> dataFilling = new ArrayList<>();
    static List<String> dataHandle = new ArrayList<>();
    static List<String> dataHandleList = new ArrayList<>();
    static List<String> dataShtulp = new ArrayList<>();

    //------------------------------------МАССИВЫ-------------------------------

//===========================================60/24==================================================
    static int [][] BB6024wind1stNo = { {12, 13, 15, 16, 17, 19, 20, 21, 23, 24, 25, 27, 28, 29, 32},
        {13, 15, 16, 17, 19, 20, 22, 23, 25, 26, 28, 29, 32, 33, 34},
        {14, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 32, 34, 36, 37},
        {16, 17, 19, 21, 22, 24, 26, 27, 29, 32, 33, 35, 37, 38, 40},
        {17, 19, 21, 22, 24, 26, 28, 29, 32, 34, 36, 37, 39, 41, 43},
        {18, 20, 22, 24, 26, 28, 29, 32, 34, 36, 38, 40, 42, 43, 45},
        {20, 22, 24, 25, 27, 29, 32, 34, 36, 38, 40, 42, 44, 46, 48},
        {21, 23, 25, 27, 29, 32, 34, 36, 38, 40, 42, 45, 47, 49, 51},
        {22, 24, 26, 29, 32, 34, 36, 38, 40, 43, 45, 47, 49, 51, 54},
        {23, 26, 28, 30, 34, 36, 38, 40, 43, 45, 47, 49, 53, 55, 57},
        {25, 27, 29, 33, 35, 38, 40, 42, 45, 47, 49, 53, 55, 57, 60},
        {26, 28, 32, 34, 37, 39, 42, 44, 47, 49, 53, 55, 58, 60, 63},
        {27, 30, 33, 36, 39, 41, 44, 46, 49, 51, 55, 58, 60, 63, 65},
        {29, 32, 35, 38, 40, 43, 46, 48, 51, 55, 57, 60, 63, 65, 68},
        {30, 34, 36, 39, 42, 45, 48, 50, 54, 57, 60, 62, 65, 68, 71},
        {32, 35, 38, 41, 44, 47, 49, 53, 56, 59, 62, 65, 68, 71, 74} };


    static int [][] BB6024wind1stOp = { {36, 37, 40, 43, 45, 49, 53, 55, 58, 61, 64},
            {39, 40, 42, 45, 48, 53, 55, 58, 61, 64, 67},
            {41, 42, 45, 48, 51, 56, 59, 62, 64, 68, 70},
            {44, 45, 48, 51, 54, 59, 61, 65, 67, 71, 75},
            {46, 47, 49, 54, 57, 61, 64, 67, 70, 75, 77},
            {49, 50, 54, 58, 61, 65, 68, 71, 75, 79, 82},
            {53, 54, 57, 60, 63, 68, 71, 75, 78, 82, 85},
            {55, 56, 59, 63, 66, 71, 75, 78, 82, 86, 89},
            {58, 59, 62, 65, 69, 74, 78, 81, 85, 89, 92},
            {60, 61, 65, 68, 72, 77, 81, 85, 88, 92, 97},
            {63, 64, 67, 71, 75, 80, 84, 88, 91, 96, 100},
            {65, 66, 70, 75, 78, 83, 87, 91, 95, 100, 103},
            {69, 70, 75, 79, 82, 87, 91, 96, 100, 104, 108},
            {71, 72, 77, 81, 85, 90, 95, 99, 103, 108, 111},
            {75, 76, 80, 84, 88, 93, 98, 102, 106, 111, 116} };


    static int [][] BB6024wind2st1Op = { {56, 57, 58, 59, 61, 64, 66, 68, 71, 74, 77, 80, 82, 84, 87},
            {60, 61, 62, 63, 65, 67, 70, 72, 76, 78, 82, 84, 86, 89, 91},
            {63, 64, 65, 66, 68, 70, 74, 77, 79, 81, 85, 88, 90, 93, 96},
            {67, 68, 69, 70, 74, 76, 79, 82, 84, 87, 91, 93, 97, 99, 102},
            {72, 73, 74, 75, 77, 80, 83, 86, 88, 91, 96, 98, 101, 104, 107},
            {75, 76, 77, 78, 81, 84, 87, 90, 92, 96, 100, 103, 106, 108, 112},
            {79, 80, 81, 82, 85, 88, 91, 93, 97, 100, 104, 107, 110, 113, 117},
            {83, 84, 85, 86, 89, 92, 96, 99, 102, 104, 109, 112, 116, 119, 122},
            {86, 87, 88, 89, 92, 96, 100, 103, 106, 109, 113, 117, 120, 123, 127},
            {90, 91, 92, 93, 97, 100, 103, 106, 110, 113, 118, 121, 124, 128, 131},
            {96, 97, 98, 99, 102, 105, 109, 112, 116, 119, 124, 127, 130, 134, 138},
            {99, 100, 101, 102, 105, 109, 112, 117, 120, 123, 128, 131, 135, 139, 143},
            {102, 103, 104, 105, 109, 112, 117, 120, 124, 127, 132, 137, 140, 144, 147},
            {106, 107, 108, 109, 112, 117, 121, 124, 128, 131, 137, 141, 144, 148, 152},
            {110, 111, 112, 113, 117, 121, 125, 128, 132, 137, 142, 145, 149, 153, 158},
            {114, 115, 116, 117, 121, 125, 129, 132, 137, 141, 146, 150, 153, 158, 162} };

    static int [][] BB6024wind3st1Op = { {76, 77, 78, 80, 83, 85, 87, 89, 91, 93, 96, 100, 102, 104, 106},
            {81, 82, 83, 85, 87, 90, 92, 95, 97, 99, 102, 105, 107, 109, 112},
            {85, 86, 87, 89, 92, 95, 98, 100, 102, 104, 107, 110, 112, 116, 117},
            {91, 92, 93, 97, 99, 102, 104, 106, 109, 111, 113, 118, 120, 123, 124},
            {97, 98, 99, 101, 104, 107, 109, 111, 114, 117, 120, 124, 126, 129, 131},
            {102, 103, 104, 106, 109, 112, 114, 118, 120, 123, 125, 129, 132, 134, 137},
            {106, 107, 108, 111, 113, 117, 120, 123, 125, 128, 131, 135, 139, 141, 143},
            {111, 112, 113, 117, 120, 123, 126, 128, 131, 134, 138, 142, 145, 147, 150},
            {117, 118, 119, 122, 125, 128, 131, 133, 137, 140, 143, 147, 150, 153, 156},
            {121, 122, 123, 126, 129, 133, 137, 140, 143, 146, 148, 153, 156, 160, 162},
            {128, 129, 130, 133, 137, 140, 143, 146, 149, 152, 155, 161, 164, 167, 170},
            {132, 133, 134, 138, 142, 145, 148, 151, 155, 159, 162, 166, 170, 173, 176},
            {138, 139, 140, 143, 146, 150, 153, 158, 161, 164, 167, 172, 175, 180, 182},
            {142, 143, 144, 148, 151, 155, 159, 163, 166, 169, 173, 179, 182, 185, 189},
            {147, 148, 149, 153, 156, 161, 165, 168, 172, 175, 180, 184, 188, 191, 195},
            {152, 153, 154, 159, 162, 166, 170, 173, 177, 181, 185, 190, 193, 197, 201} };


    static int [][] BB6024wind4st2Op = { {135, 136, 137, 140, 142, 145, 147, 150, 153, 155, 159, 161, 164, 166, 169},
            {142, 143, 144, 146, 149, 151, 154, 158, 161, 164, 166, 169, 171, 174, 177},
            {148, 149, 150, 153, 156, 159, 162, 165, 168, 171, 174, 176, 180, 183, 185},
            {156, 157, 158, 161, 163, 166, 169, 172, 175, 179, 182, 185, 188, 190, 193},
            {163, 164, 165, 168, 171, 174, 177, 181, 184, 187, 190, 193, 196, 200, 203},
            {169, 170, 171, 174, 179, 181, 185, 188, 191, 194, 197, 201, 204, 207, 210},
            {177, 178, 179, 182, 185, 188, 191, 195, 198, 202, 206, 209, 212, 215, 218},
            {186, 187, 188, 192, 195, 198, 202, 206, 209, 213, 216, 219, 223, 227, 230},
            {193, 194, 195, 198, 203, 206, 209, 213, 217, 221, 224, 228, 231, 234, 237},
            {200, 201, 202, 206, 209, 213, 216, 221, 225, 228, 232, 235, 238, 243, 246},
            {207, 208, 209, 212, 216, 221, 224, 228, 232, 235, 239, 243, 247, 250, 254},
            {214, 215, 216, 221, 224, 228, 231, 235, 239, 244, 248, 251, 255, 259, 263},
            {222, 223, 224, 227, 231, 235, 238, 243, 248, 251, 255, 259, 263, 267, 271},
            {228, 229, 230, 234, 238, 242, 246, 250, 255, 258, 263, 267, 271, 275, 279} };

    static int [][] BB6024balDor = { {75, 76, 80, 85, 89, 96, 100, 105},
            {78, 79, 83, 87, 92, 98, 103, 108},
            {84, 85, 89, 95, 99, 105, 110, 115},
            {86, 87, 92, 97, 102, 108, 112, 117},
            {89, 90, 95, 100, 105, 111, 117, 122},
            {91, 92, 98, 103, 108, 114, 119, 124},
            {95, 96, 100, 105, 110, 117, 122, 127},
            {97, 98, 103, 108, 113, 120, 125, 130} };

    static int [][] BB6024wind2st2Op = { {75, 76, 77, 78, 80, 82, 86, 88, 90, 93, 99, 101, 103},
            {79, 80, 81, 82, 85, 87, 90, 93, 96, 98, 104, 106, 109},
            {82, 83, 84, 85, 88, 91, 95, 97, 100, 102, 108, 110, 113},
            {89, 90, 91, 92, 96, 99, 102, 105, 107, 110, 117, 119, 122},
            {95, 96, 97, 98, 101, 103, 107, 110, 112, 116, 122, 124, 127},
            {99, 100, 101, 102, 105, 108, 112, 114, 118, 121, 127, 130, 132},
            {104, 105, 106, 107, 110, 113, 117, 120, 123, 126, 132, 135, 139},
            {109, 110, 111, 112, 116, 119, 123, 126, 129, 132, 139, 142, 145},
            {114, 115, 116, 117, 120, 123, 127, 130, 133, 138, 144, 147, 150},
            {118, 119, 120, 121, 125, 128, 132, 135, 139, 143, 149, 152, 155},
            {126, 127, 128, 129, 132, 135, 141, 144, 147, 151, 158, 161, 164},
            {130, 131, 132, 133, 138, 141, 145, 149, 152, 156, 163, 166, 170},
            {135, 136, 137, 138, 142, 146, 150, 153, 158, 161, 168, 171, 175} };

    static int [][] BB6024wind3st2Op = { {98, 99, 100, 102, 105, 107, 110, 112, 116, 118, 120, 123, 128, 130, 133},
            {104, 105, 106, 108, 110, 113, 117, 119, 122, 124, 127, 129, 135, 138, 140},
            {108, 109, 110, 113, 116, 119, 122, 124, 127, 130, 132, 135, 141, 144, 146},
            {117, 118, 119, 122, 125, 127, 131, 133, 137, 139, 142, 145, 150, 153, 156},
            {123, 124, 125, 128, 130, 133, 137, 140, 143, 146, 148, 151, 158, 161, 163},
            {128, 129, 130, 133, 137, 140, 144, 146, 149, 152, 155, 159, 165, 167, 170},
            {135, 136, 137, 140, 143, 146, 149, 152, 155, 159, 162, 165, 171, 174, 177},
            {141, 142, 143, 146, 149, 152, 156, 160, 163, 166, 169, 172, 179, 182, 185},
            {147, 148, 149, 152, 155, 159, 163, 166, 169, 172, 176, 180, 186, 189, 192},
            {152, 153, 154, 158, 162, 165, 169, 172, 175, 180, 183, 186, 192, 196, 200},
            {162, 163, 164, 167, 170, 174, 179, 182, 186, 189, 192, 196, 203, 206, 210},
            {167, 168, 169, 173, 176, 181, 185, 188, 192, 195, 200, 203, 209, 213, 216},
            {173, 174, 175, 179, 183, 186, 191, 194, 198, 202, 206, 210, 216, 221, 224},
            {179, 180, 181, 185, 189, 192, 197, 201, 205, 209, 212, 216, 223, 227, 231},
            {185, 186, 187, 191, 195, 200, 204, 208, 212, 215, 219, 224, 231, 234, 238},
            {191, 192, 193, 197, 202, 205, 210, 214, 218, 223, 227, 230, 237, 242, 246} };

    static int [][] BB6024wind2stNo = { {20, 22, 23, 25, 26, 27, 29, 30, 33, 34, 36, 37, 39, 40, 41},
            {22, 24, 25, 27, 28, 30, 32, 34, 36, 37, 39, 40, 42, 43, 45},
            {24, 26, 27, 29, 32, 33, 35, 37, 38, 40, 42, 43, 45, 47, 48},
            {26, 28, 30, 32, 34, 36, 38, 39, 41, 43, 45, 46, 48, 50, 53},
            {28, 30, 33, 35, 36, 38, 40, 42, 44, 46, 48, 49, 51, 54, 56},
            {30, 33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 54, 55, 57, 59},
            {33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 55, 57, 59, 61, 63},
            {35, 37, 39, 41, 44, 46, 48, 50, 53, 55, 58, 60, 62, 64, 66},
            {37, 39, 41, 44, 46, 48, 50, 54, 56, 58, 61, 63, 65, 67, 70},
            {39, 41, 44, 46, 48, 51, 54, 56, 59, 61, 63, 66, 68, 71, 74},
            {41, 43, 46, 48, 51, 54, 57, 59, 62, 64, 66, 69, 71, 75, 77},
            {43, 45, 48, 50, 54, 57, 59, 62, 64, 67, 69, 72, 76, 78, 81},
            {45, 47, 50, 54, 56, 59, 62, 64, 67, 70, 72, 76, 79, 81, 84},
            {47, 49, 53, 56, 59, 62, 64, 67, 70, 74, 76, 79, 82, 85, 87},
            {49, 53, 55, 58, 61, 64, 67, 70, 74, 76, 79, 82, 85, 88, 91},
            {51, 55, 58, 61, 64, 66, 69, 72, 76, 79, 82, 85, 88, 91, 95} };

    static int [][] BB6024wind3stNo = { {53, 55, 56, 58, 60, 62, 63, 65, 67, 69, 70, 72, 75, 77, 78},
            {56, 58, 60, 62, 64, 66, 68, 69, 71, 74, 76, 78, 80, 82, 83},
            {60, 62, 64, 66, 68, 70, 72, 75, 77, 79, 81, 83, 85, 86, 88},
            {64, 66, 68, 70, 72, 75, 77, 79, 81, 83, 85, 87, 89, 91, 93},
            {67, 69, 71, 75, 77, 79, 81, 83, 85, 88, 90, 92, 95, 97, 99},
            {71, 74, 76, 78, 81, 83, 85, 88, 90, 92, 95, 98, 100, 102, 104},
            {75, 78, 80, 82, 85, 87, 89, 92, 95, 97, 100, 102, 105, 107, 109},
            {79, 81, 84, 86, 89, 91, 95, 97, 99, 102, 104, 107, 109, 112, 114},
            {82, 85, 87, 90, 93, 96, 99, 101, 104, 106, 109, 112, 114, 118, 120},
            {86, 89, 91, 95, 98, 100, 103, 106, 108, 111, 114, 117, 120, 123, 125},
            {89, 92, 96, 99, 102, 104, 107, 110, 113, 116, 119, 122, 125, 127, 130},
            {93, 97, 100, 103, 105, 108, 111, 114, 118, 121, 124, 127, 129, 132, 135},
            {98, 100, 103, 106, 109, 112, 116, 119, 122, 125, 128, 131, 134, 138, 141},
            {101, 104, 107, 110, 113, 117, 120, 124, 127, 130, 133, 137, 140, 143, 146},
            {105, 108, 111, 114, 118, 121, 125, 128, 131, 134, 138, 142, 145, 148, 151},
            {108, 111, 116, 119, 122, 126, 129, 132, 135, 140, 143, 146, 149, 153, 156} };

//===========================================60/32==================================================

    static int [][] BB6032wind1stNo = { {12, 13, 14, 15, 17, 18, 19, 20, 22, 23, 24, 25, 27, 28, 29},
            {13, 15, 16, 17, 19, 20, 22, 23, 24, 26, 27, 29, 30, 32, 34},
            {15, 16, 18, 19, 21, 22, 24, 25, 27, 29, 30, 33, 34, 36, 37},
            {16, 18, 20, 21, 23, 25, 26, 28, 30, 32, 34, 36, 38, 39, 41},
            {18, 20, 21, 23, 25, 27, 29, 32, 33, 35, 37, 39, 41, 43, 45},
            {19, 21, 23, 25, 27, 29, 32, 34, 36, 38, 40, 42, 44, 46, 48},
            {21, 23, 25, 27, 29, 32, 35, 37, 39, 41, 43, 45, 47, 50, 53},
            {22, 24, 27, 29, 32, 35, 37, 39, 42, 44, 46, 48, 51, 54, 56},
            {24, 26, 29, 32, 34, 37, 39, 42, 44, 47, 49, 53, 55, 58, 60},
            {25, 28, 30, 34, 37, 39, 42, 44, 47, 50, 53, 56, 58, 61, 64},
            {27, 29, 33, 36, 39, 41, 44, 47, 50, 53, 56, 59, 62, 64, 67},
            {28, 32, 35, 38, 41, 44, 47, 49, 53, 56, 59, 62, 65, 68, 71},
            {30, 34, 37, 40, 43, 46, 49, 53, 56, 59, 62, 65, 68, 71, 75},
            {32, 35, 38, 42, 45, 48, 51, 56, 59, 62, 65, 68, 72, 76, 79},
            {34, 37, 40, 44, 47, 50, 55, 58, 61, 65, 68, 72, 76, 79, 83},
            {35, 39, 42, 46, 49, 54, 57, 61, 64, 68, 71, 76, 79, 83, 86} };

    static int [][] BB6032wind1stOp = { {38, 39, 41, 44, 47, 51, 55, 58, 61, 64, 67},
            {40, 41, 44, 47, 50, 55, 58, 62, 65, 68, 71},
            {44, 44, 47, 50, 54, 59, 62, 65, 68, 72, 76},
            {46, 47, 50, 54, 58, 62, 65, 69, 72, 77, 80},
            {49, 49, 53, 57, 60, 65, 68, 72, 76, 80, 84},
            {52, 54, 57, 61, 65, 69, 74, 78, 81, 86, 89},
            {55, 56, 60, 64, 68, 74, 77, 81, 85, 89, 93},
            {58, 59, 63, 67, 71, 77, 81, 85, 89, 93, 98},
            {60, 62, 66, 70, 75, 80, 84, 89, 92, 98, 102},
            {64, 65, 69, 74, 78, 84, 88, 92, 98, 102, 106},
            {66, 67, 72, 77, 81, 87, 91, 97, 101, 106, 110},
            {68, 70, 75, 80, 84, 90, 96, 100, 105, 110, 114},
            {73, 75, 80, 84, 89, 96, 101, 105, 110, 116, 121},
            {75, 78, 82, 87, 92, 99, 104, 109, 114, 120, 125},
            {79, 80, 85, 90, 96, 102, 107, 113, 118, 124, 129} };

    static int [][] BB6032wind2st1Op = { {60, 61, 62, 63, 66, 68, 71, 75, 77, 80, 84, 86, 89, 92, 96},
            {64, 65, 66, 67, 70, 74, 77, 79, 82, 85, 89, 92, 95, 98, 101},
            {68, 69, 70, 71, 74, 77, 81, 83, 86, 89, 93, 97, 100, 103, 106},
            {74, 75, 76, 77, 80, 83, 86, 89, 92, 96, 101, 104, 107, 110, 114},
            {78, 79, 80, 81, 84, 87, 91, 95, 98, 101, 106, 109, 112, 117, 120},
            {82, 83, 84, 85, 88, 92, 96, 100, 103, 106, 111, 114, 119, 122, 126},
            {86, 87, 88, 89, 92, 97, 101, 104, 108, 111, 117, 120, 124, 128, 131},
            {90, 91, 92, 93, 98, 101, 105, 109, 113, 117, 122, 126, 130, 133, 138},
            {95, 96, 97, 98, 102, 106, 110, 114, 118, 122, 127, 131, 135, 140, 144},
            {99, 100, 101, 102, 106, 110, 114, 119, 123, 127, 132, 137, 141, 145, 150},
            {105, 106, 107, 108, 112, 117, 121, 125, 129, 133, 140, 144, 148, 152, 158},
            {109, 110, 111, 112, 117, 121, 126, 130, 134, 139, 145, 149, 154, 159, 164},
            {114, 115, 116, 117, 121, 125, 130, 134, 140, 144, 150, 154, 160, 164, 169},
            {117, 118, 119, 120, 125, 130, 134, 140, 145, 149, 155, 161, 165, 170, 175},
            {122, 123, 124, 125, 129, 134, 140, 145, 150, 154, 161, 166, 171, 176, 182},
            {126, 127, 128, 129, 134, 139, 145, 149, 154, 160, 166, 171, 176, 182, 187} };

    static int [][] BB6032wind3st1Op = { {83, 84, 85, 87, 90, 93, 96, 98, 101, 103, 106, 110, 112, 114, 118},
            {88, 89, 90, 93, 97, 99, 102, 105, 107, 110, 112, 117, 120, 123, 125},
            {94, 95, 96, 99, 102, 105, 108, 110, 113, 117, 120, 124, 126, 129, 132},
            {101, 102, 103, 106, 109, 112, 116, 119, 122, 125, 128, 132, 135, 139, 142},
            {107, 108, 109, 112, 116, 119, 122, 125, 128, 131, 134, 140, 143, 146, 149},
            {112, 113, 114, 118, 122, 125, 128, 131, 135, 139, 142, 147, 150, 153, 156},
            {119, 120, 121, 124, 127, 131, 134, 139, 142, 145, 149, 153, 158, 161, 165},
            {124, 125, 126, 130, 133, 138, 142, 145, 149, 152, 156, 162, 165, 169, 172},
            {130, 131, 132, 135, 140, 144, 148, 151, 155, 160, 163, 168, 172, 176, 180},
            {136, 137, 138, 142, 146, 150, 154, 159, 162, 166, 170, 175, 180, 184, 188},
            {143, 144, 145, 149, 153, 159, 162, 166, 170, 174, 179, 185, 189, 193, 197},
            {149, 150, 151, 155, 160, 164, 168, 173, 177, 182, 186, 191, 196, 201, 205},
            {154, 155, 156, 161, 166, 170, 175, 180, 184, 188, 193, 198, 204, 208, 212},
            {161, 162, 163, 167, 172, 176, 182, 186, 190, 195, 200, 206, 211, 215, 219},
            {166, 167, 168, 173, 179, 183, 188, 193, 197, 203, 207, 213, 218, 223, 228},
            {172, 173, 174, 180, 184, 189, 194, 200, 205, 209, 214, 221, 226, 230, 235} };

    static int [][] BB6032wind4st2Op = { {146, 147, 148, 151, 154, 158, 161, 164, 168, 171, 174, 177, 181, 184, 187},
            {153, 154, 155, 159, 163, 166, 169, 172, 176, 180, 183, 187, 190, 193, 196},
            {162, 163, 164, 167, 171, 174, 177, 181, 186, 189, 192, 196, 200, 203, 207},
            {169, 170, 171, 175, 179, 183, 186, 190, 194, 197, 202, 205, 209, 212, 216},
            {179, 180, 181, 184, 188, 191, 195, 200, 204, 208, 211, 215, 219, 223, 227},
            {186, 187, 188, 192, 196, 200, 204, 208, 212, 216, 221, 225, 229, 232, 236},
            {193, 194, 195, 200, 204, 208, 212, 216, 222, 226, 230, 234, 238, 243, 246},
            {205, 206, 207, 211, 215, 219, 224, 228, 233, 237, 242, 247, 251, 255, 259},
            {212, 213, 214, 219, 224, 228, 232, 237, 243, 247, 251, 255, 260, 265, 269},
            {221, 222, 223, 227, 232, 236, 242, 246, 251, 255, 260, 265, 270, 274, 278},
            {228, 229, 230, 235, 240, 245, 250, 254, 259, 265, 270, 274, 279, 284, 289},
            {236, 237, 238, 244, 249, 254, 258, 264, 269, 274, 279, 285, 289, 294, 299},
            {245, 246, 247, 252, 257, 263, 267, 272, 278, 284, 289, 293, 298, 303, 309},
            {252, 253, 254, 259, 265, 270, 275, 280, 287, 292, 297, 302, 308, 313, 318} };

    static int [][] BB6032balDor = { {80, 81, 86, 91, 97, 103, 109, 115},
            {82, 83, 88, 95, 100, 107, 112, 118},
            {89, 90, 96, 102, 107, 114, 120, 126},
            {91, 92, 99, 105, 110, 118, 124, 130},
            {95, 96, 102, 108, 113, 121, 127, 133},
            {98, 99, 104, 111, 117, 125, 131, 137},
            {100, 101, 107, 114, 121, 128, 134, 140},
            {103, 104, 110, 117, 124, 131, 138, 144} };

    static int [][] BB6032wind2st2Op = { {78, 79, 80, 81, 84, 86, 90, 93, 96, 99, 104, 107, 110},
            {83, 84, 85, 86, 89, 92, 96, 99, 102, 105, 110, 113, 117},
            {87, 88, 89, 90, 93, 97, 100, 103, 106, 109, 116, 119, 122},
            {95, 96, 97, 98, 101, 104, 108, 111, 116, 119, 125, 128, 131},
            {100, 101, 102, 103, 106, 110, 114, 118, 121, 124, 131, 134, 138},
            {105, 106, 107, 108, 111, 116, 120, 123, 127, 130, 138, 141, 144},
            {110, 111, 112, 113, 117, 121, 125, 129, 132, 137, 143, 147, 151},
            {116, 117, 118, 119, 123, 127, 131, 135, 140, 143, 150, 154, 158},
            {121, 122, 123, 124, 128, 132, 137, 141, 145, 149, 156, 161, 165},
            {126, 127, 128, 129, 133, 138, 143, 147, 151, 155, 163, 167, 171},
            {135, 136, 137, 138, 142, 146, 151, 155, 160, 165, 172, 176, 181},
            {139, 140, 141, 142, 147, 151, 156, 162, 166, 170, 177, 183, 187},
            {144, 145, 146, 147, 152, 156, 162, 167, 171, 176, 184, 189, 193} };

    static int [][] BB6032wind3st2Op = { {104, 105, 106, 109, 111, 114, 118, 121, 124, 126, 129, 132, 138, 141, 144},
            {110, 111, 112, 116, 119, 122, 125, 128, 131, 134, 138, 141, 146, 149, 152},
            {116, 117, 118, 121, 124, 127, 131, 134, 138, 141, 144, 147, 153, 156, 160},
            {125, 126, 127, 131, 134, 138, 142, 145, 148, 151, 154, 159, 165, 168, 171},
            {132, 133, 134, 138, 141, 145, 149, 152, 155, 160, 163, 166, 172, 176, 180},
            {139, 140, 141, 145, 148, 152, 156, 160, 164, 167, 171, 174, 181, 185, 188},
            {145, 146, 147, 151, 155, 159, 164, 167, 171, 174, 179, 183, 189, 193, 196},
            {152, 153, 154, 159, 163, 167, 171, 175, 180, 184, 187, 191, 198, 202, 206},
            {160, 161, 162, 166, 170, 173, 179, 183, 187, 191, 195, 200, 206, 210, 214},
            {166, 167, 168, 172, 176, 181, 186, 190, 194, 198, 203, 207, 214, 218, 223},
            {175, 176, 177, 183, 187, 191, 196, 201, 205, 210, 214, 218, 226, 230, 235},
            {183, 184, 185, 189, 193, 198, 204, 208, 213, 217, 222, 227, 234, 238, 244},
            {189, 190, 191, 195, 201, 205, 211, 215, 221, 225, 230, 234, 243, 247, 252},
            {195, 196, 197, 203, 208, 212, 218, 223, 228, 233, 237, 243, 251, 255, 260},
            {203, 204, 205, 210, 215, 221, 226, 231, 236, 242, 246, 251, 259, 265, 270},
            {209, 210, 211, 216, 222, 227, 233, 238, 244, 249, 254, 259, 268, 273, 278} };

    static int [][] BB6032wind2stNo = { {22, 23, 25, 27, 28, 30, 33, 34, 36, 38, 40, 41, 43, 45, 46},
            {24, 26, 28, 29, 32, 34, 36, 38, 40, 41, 43, 45, 47, 49, 51},
            {26, 28, 30, 33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 54, 56},
            {28, 30, 34, 36, 38, 40, 42, 44, 46, 49, 51, 54, 56, 58, 60},
            {30, 34, 36, 38, 41, 43, 45, 48, 50, 53, 56, 58, 60, 62, 65},
            {34, 36, 39, 41, 44, 46, 48, 51, 54, 57, 59, 62, 64, 67, 69},
            {36, 39, 41, 44, 46, 49, 53, 55, 58, 60, 63, 66, 68, 71, 74},
            {38, 41, 44, 46, 49, 53, 56, 58, 61, 64, 67, 70, 72, 76, 79},
            {40, 43, 46, 49, 53, 56, 59, 62, 65, 68, 70, 74, 77, 80, 83},
            {43, 46, 49, 53, 56, 59, 62, 65, 68, 71, 75, 78, 81, 84, 88},
            {45, 48, 51, 55, 59, 62, 65, 68, 72, 76, 79, 82, 85, 89, 92},
            {47, 50, 55, 58, 61, 65, 68, 72, 76, 79, 83, 86, 89, 93, 97},
            {49, 54, 57, 61, 64, 68, 71, 76, 79, 83, 86, 90, 95, 98, 102},
            {51, 56, 60, 63, 67, 71, 75, 79, 83, 87, 90, 95, 99, 102, 106},
            {55, 59, 62, 66, 70, 75, 79, 82, 86, 90, 95, 99, 103, 106, 110},
            {57, 61, 65, 69, 74, 78, 82, 86, 90, 95, 99, 103, 107, 111, 116} };

    static int [][] BB6032wind3stNo = { {59, 61, 64, 66, 68, 70, 72, 75, 77, 80, 82, 84, 86, 88, 90},
            {64, 66, 68, 71, 74, 76, 78, 81, 83, 85, 88, 90, 92, 96, 98},
            {68, 70, 74, 76, 79, 81, 84, 86, 89, 91, 93, 97, 99, 102, 104},
            {72, 76, 78, 81, 84, 86, 89, 92, 95, 98, 100, 103, 106, 108, 111},
            {78, 80, 83, 86, 89, 91, 95, 98, 101, 103, 106, 109, 112, 114, 118},
            {82, 85, 88, 91, 95, 97, 100, 103, 106, 109, 112, 116, 119, 122, 125},
            {86, 89, 92, 96, 100, 103, 106, 109, 112, 116, 119, 122, 125, 128, 131},
            {91, 95, 98, 101, 104, 108, 111, 114, 118, 122, 125, 128, 131, 134, 139},
            {96, 99, 103, 106, 109, 113, 117, 121, 124, 127, 131, 134, 138, 142, 145},
            {100, 104, 107, 111, 114, 119, 122, 126, 129, 133, 137, 141, 144, 148, 152},
            {105, 108, 112, 117, 120, 124, 128, 131, 135, 140, 143, 147, 151, 154, 159},
            {109, 113, 118, 121, 125, 129, 133, 138, 141, 145, 149, 153, 158, 162, 165},
            {113, 118, 122, 126, 130, 134, 139, 143, 147, 151, 155, 160, 164, 168, 172},
            {119, 123, 127, 131, 135, 140, 144, 148, 153, 158, 162, 166, 170, 174, 179},
            {123, 127, 131, 137, 141, 145, 150, 154, 159, 163, 168, 172, 176, 182, 186},
            {127, 132, 137, 141, 146, 150, 155, 160, 165, 169, 174, 179, 183, 188, 192} };
//--------------------------------------------------------------------------------------------

    String[] dataType = {"Окно 1 створ.", "Окно 2 створ.", "Окно 3 створ.", "Балконная рама (4 створ.)", "Дверь балконная"};
    Double [] glassPriceItems = {0.0, 0.0, 0.0, 0.0};
    double [] handlePriceItems = {0, 0, 0};

    //--------------------------------------------------------------------------------------------------
    static ArrayAdapter<String> adapterTypeOfType;
    static ArrayAdapter<String> adapterTypeOfGlass;

    static ArrayAdapter<String> adapterFurnit;
    static ArrayAdapter<String> adapterLamination;
    static ArrayAdapter<String> adapterRegion;
    static ArrayAdapter<String> adapterProfile;

    static ArrayAdapter<String> adapterHight;
    static ArrayAdapter<String> adapterWidth;

    static ArrayAdapter<String> adapterShpros;
    static ArrayAdapter<String> adapterShprosWidth;

    static ArrayAdapter<String> adapterGlassDif;
    static ArrayAdapter<String> adapterGlassDifLst;

    static ArrayAdapter<String> adapterFigure;

    static ArrayAdapter<String> adapterFilling;

    static ArrayAdapter<String> adapterHandle;
    static ArrayAdapter<String> adapterHandleLst;

    static ArrayAdapter<String> adapterShtulp;

//-----------------------------------------------------------------------------------------------------
    public AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addwindow);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        final Intent prodListBut = new Intent(AddWindowActivity.this, ProductList.class);

        final ListView listGlassDif = findViewById(R.id.listGlass);
        final ListView listHandle =  findViewById(R.id.listHandle);
//----------------------------------------
        final ArrayAdapter<String> adapterType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataType);

        adapterProfile = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataProfile);

        adapterTypeOfGlass = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataTypeOfGlass);

        adapterFurnit = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataFurnit);

        adapterTypeOfType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataTypeOfType);

        adapterHight = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataHight);

        adapterWidth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataWidth);

        adapterLamination = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataLamination);

        adapterRegion = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataRegion);

        adapterShpros = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataShpros);

        adapterShprosWidth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataShprosWidth);

        adapterGlassDif = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataGlassDif);
        adapterGlassDifLst = new ArrayAdapter<>(this, R.layout.listglassitem, dataGlassList);
        listGlassDif.setAdapter(adapterGlassDifLst);

        adapterFigure = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataFigure);

        adapterFilling = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataFilling);

        adapterHandle = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataHandle);
        adapterHandleLst = new ArrayAdapter<>(this, R.layout.listglassitem, dataHandleList);
        listHandle.setAdapter(adapterHandleLst);

        adapterShtulp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataShtulp);
//----------------------------------------
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterProfile.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterProfile.clear();
        adapterProfile.addAll(addList(R.array.dtaProfile));

        adapterFurnit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterFurnit.clear();
        adapterFurnit.addAll(addList(R.array.dtaFurnit));

        adapterTypeOfGlass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterTypeOfType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterHight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterWidth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterLamination.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterLamination.clear();
        adapterLamination.addAll(addList(R.array.dtaLamination));

        adapterRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterRegion.clear();
        adapterRegion.addAll(addList(R.array.dtaRegion));

        adapterShpros.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterShpros.clear();
        adapterShpros.addAll(addList(R.array.dtaShpros));

        adapterShprosWidth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterShprosWidth.clear();
        adapterShprosWidth.addAll(addList(R.array.Width_shpros));

        adapterGlassDif.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterGlassDif.clear();
        adapterGlassDif.addAll(addList(R.array.dtaGlassDif));

        adapterFigure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterFigure.clear();
        adapterFigure.addAll(addList(R.array.dtaFigure));

        adapterFilling.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterFilling.clear();
        adapterFilling.addAll(addList(R.array.Type_Door));

        adapterHandle.setDropDownViewResource(R.layout.layout_spinner_handle);
        adapterHandle.clear();
        adapterHandle.addAll(addList(R.array.dtaHandle1));

        adapterShtulp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterShtulp.clear();
        adapterShtulp.addAll(addList(R.array.dtaShtulp));
//----------------------------------------

        spinnerType = findViewById(R.id.spinner_type);

        spinnerProfile = findViewById(R.id.spinner_profile);

        spinnerTypeOfGlass = findViewById(R.id.spinner_typeOfGlass);

        spinnerFurnit = findViewById(R.id.spinner_furnit);
        spinnerFurnit.setVisibility(View.INVISIBLE);

        spinnerTypeOfType = findViewById(R.id.spinner_typeOfType);

        spinnerHight = findViewById(R.id.spinner_hight);

        spinnerWidth = findViewById(R.id.spinner_width);

        spinnerLamination = findViewById(R.id.spinner_lamination);

        spinnerRegion = findViewById(R.id.spinner_region);
        spinnerRegion.setVisibility(View.INVISIBLE);

        spinnerShpros = findViewById(R.id.spinner_typeOfShpros);

        spinnerShprosWidth = findViewById(R.id.spinner_widthShpros);
        spinnerShprosWidth.setVisibility(View.INVISIBLE);

        spinnerGlassDif = findViewById(R.id.spinner_glassDif);

        spinnerFigure = findViewById(R.id.spinner_figure);

        spinnerFilling = findViewById(R.id.spinner_filling);
        spinnerFilling.setVisibility(View.INVISIBLE);

        spinnerHandle = findViewById(R.id.spinner_handle);
        spinnerHandle.setVisibility(View.INVISIBLE);

        spinnerShtulp = findViewById(R.id.spinner_shtulp);
        spinnerShtulp.setVisibility(View.INVISIBLE);

//----------------------------------------
        final Button setTypeButton = findViewById(R.id.button_addType);
        final Button prodLstBut = findViewById(R.id.button_ProdLst);
        final Button addHandleBut = findViewById(R.id.button_addHandle);
        addHandleBut.setVisibility(View.INVISIBLE);
//---------------------------------ЗАУПСК ОКНА------------------------------------------------------
        //Если запуск не через лист(Добавить в блок)
        if (!addFromList) {
            prodLstBut.setVisibility(View.VISIBLE);
        }
        //Если выбрали через лист(Добавить в блок)
        else {
            prodLstBut.setVisibility(View.INVISIBLE);
        }
//---------------ТИП ОКНА-------------------------

        spinnerType.setAdapter(adapterType);
        // заголовок
        spinnerType.setPrompt("Тип изделия");
        // выделяем элемент
        spinnerType.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionType, long idType) {

                positionType1 = positionType;

                positionHight1 = 0;
                positionWidth1 = 0;
                positionTypeOfType1 = 0;
                positionFilling1 = 0;
                spinnerHight.setSelection(0);
                spinnerWidth.setSelection(0);
                spinnerTypeOfType.setSelection(0);
                spinnerFilling.setSelection(0);


                //Если балконная дверь на что то меняется, окно выбирается глухое
                //Скрывается заполнение, ручки и фурнитура(Так как окно будет сразу глухое)
                //Возвращается фигура и тип окна
                if (balDorFlag == true) {
                    spinnerFilling.setVisibility(View.INVISIBLE);
                    spinnerHandle.setVisibility(View.INVISIBLE);
                    addHandleBut.setVisibility(View.INVISIBLE);
                    spinnerFurnit.setVisibility(View.INVISIBLE);

                    spinnerTypeOfType.setVisibility(View.VISIBLE);
                    spinnerFigure.setVisibility(View.VISIBLE);
                    balDorFlag = false;
                }

                //Когда выбирается балконная дверь
                if (positionType1 == 4) {
                    //Так как тип ставится на глухое нужно показать ручки, фурнитуру и заполнение
                    spinnerHandle.setVisibility(View.VISIBLE);
                    addHandleBut.setVisibility(View.VISIBLE);
                    spinnerFurnit.setVisibility(View.VISIBLE);
                    spinnerFilling.setVisibility(View.VISIBLE);
                    //Скрывается тип окон, фигуры
                    //Фигуры обнуляются
                    spinnerTypeOfType.setVisibility(View.INVISIBLE);

                    spinnerFigure.setVisibility(View.INVISIBLE);
                    priceFigure = 0;
                    positionFigure1 = 0;
                    spinnerFigure.setSelection(0);
                }

                flag = true;
                setPrice(positionType1, positionTypeOfType1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________ТИП ПРОФИЛЯ___________________

        spinnerProfile.setAdapter(adapterProfile);
        // заголовок
        spinnerProfile.setPrompt("Тип профиля");
        // выделяем элемент
        spinnerProfile.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerProfile.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionProfile, long idProfile) {

                positionProfile1 = positionProfile;
                positionTypeOfGlass1 = 0;
                spinnerTypeOfGlass.setSelection(0);

                //Если выбрана балконная дверь и меняется профиль
                if(balDorFlag) {
                    //Если выбрано заполнение сендвичем на 100% или 50%
                    if ( (positionFilling1 == 1 || positionFilling1 == 2) && positionProfile1 != 4) {
                        setProfile(positionProfile1, positionTypeOfGlass1);
                        positionTypeOfGlass1 = 1;
                        spinnerTypeOfGlass.setSelection(1);
                    }
                }

                setProfile(positionProfile1, positionTypeOfGlass1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________________ТИП СТЕКЛОПАКЕТА__________________

        spinnerTypeOfGlass.setAdapter(adapterTypeOfGlass);
        // заголовок
        spinnerTypeOfGlass.setPrompt("Тип стеклопакета");
        // выделяем элемент
        spinnerTypeOfGlass.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerTypeOfGlass.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionTypeOfGlass, long idTypeOfGlass) {

                positionTypeOfGlass1 = positionTypeOfGlass;

                //Если выбрана балконная дверь
                if(balDorFlag) {

                    //Если выбрано заполнение сендвичем на 100 или 50 % и профиль не salamander
                    if ((positionFilling1 == 1 || positionFilling1 == 2) && !salamander) {

                        //Если выбран профиль 60мм и пытаются выбрать 24 стеклопакет
                        if( (positionProfile1 == 0 || positionProfile1 == 2) && positionTypeOfGlass1 == 0 ) {
                            positionTypeOfGlass1 = 1;
                            spinnerTypeOfGlass.setSelection(1);
                        }

                        //Если выбран профиль 70мм, но не саламандер
                        else {
                            //Если пытаюстся выбрать стекло 24мм, то автоматически ставится на 32мм
                            if(positionTypeOfGlass1 == 0) {
                                positionTypeOfGlass1 = 1;
                                spinnerTypeOfGlass.setSelection(1);
                            }
                        }
                    }
                }

                setProfile(positionProfile1, positionTypeOfGlass1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________________ФУРНИТУРА__________________
        spinnerFurnit.setAdapter(adapterFurnit);
        // заголовок
        spinnerFurnit.setPrompt("Тип профиля");
        // выделяем элемент
        spinnerFurnit.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerFurnit.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionFurnit, long idFurnit) {
                positionFurnit1 = positionFurnit;
                furnitPrice = 0;

                //Если выбрана балконная дверь с 2-x сторонней ручкой и пытаются выбрать kale
                if (balDorFlag) {
                    if ( (dataHandleList.get(0).equals(dataHandle.get(6))) && positionFurnit1 == 0) {
                        positionFurnit1 = 1;
                        spinnerFurnit.setSelection(1);
                    }
                }
                //Если выбран штульп и меняют фурнитуру
                if(positionShtulp1 == 1) {
                    //Если пытаются выбрать фурнитуру kale с выбранным штульпом
                    if(positionFurnit1 == 0) {
                        positionFurnit1 = 1;
                        spinnerFurnit.setSelection(1);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________________ТИП__________________
        spinnerTypeOfType.setAdapter(adapterTypeOfType);
        // заголовок
        spinnerTypeOfType.setPrompt("Тип");
        // выделяем элемент
        spinnerTypeOfType.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerTypeOfType.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionTypeOfType, long idTypeOfType) {

                flag = true;
                positionHight1 = 0;
                positionWidth1 = 0;
                positionTypeOfType1 = positionTypeOfType;
                spinnerHight.setSelection(0);
                spinnerWidth.setSelection(0);
                setPrice(positionType1, positionTypeOfType1);

                //Если выбрано гулхое окно (Не балконная дверь) показываем тип фигуры окна и скрываем ручки
                if (positionTypeOfType1 == 0 && !balDorFlag) {
                    priceFigure = 0;
                    positionFigure1 = 0;
                    spinnerFigure.setSelection(0);
                    spinnerFigure.setVisibility(View.VISIBLE);
                    spinnerHandle.setVisibility(View.INVISIBLE);
                    addHandleBut.setVisibility(View.INVISIBLE);
                    spinnerFurnit.setVisibility(View.INVISIBLE);
                }
                //Если выбраны открывающиеся окна и не балконная дверь - возвращаем ручки
                else if (!balDorFlag) {
                    spinnerHandle.setVisibility(View.VISIBLE);
                    addHandleBut.setVisibility(View.VISIBLE);
                    spinnerFurnit.setVisibility(View.VISIBLE);
                }
                //Если балконная дверь, показываем ручки и скрываем фигуры
                else {
                    priceFigure = 0;
                    positionFigure1 = 0;
                    spinnerFigure.setSelection(0);
                    spinnerFigure.setVisibility(View.INVISIBLE);
                    spinnerHandle.setVisibility(View.VISIBLE);
                    addHandleBut.setVisibility(View.VISIBLE);
                    spinnerFurnit.setVisibility(View.VISIBLE);

                }
                //Если выбрано глухое окно или открывающаяся 1 створка
                //Скрывается штульп
                if (positionTypeOfType1 == 0 || positionTypeOfType1 == 1) {
                    positionShtulp1 = 0;
                    spinnerShtulp.setSelection(0);
                    spinnerShtulp.setVisibility(View.INVISIBLE);
                }
                else {
                    spinnerShtulp.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________ФИГУРА__________________

        spinnerFigure.setAdapter(adapterFigure);
        // заголовок
        spinnerFigure.setPrompt("Высота");
        // выделяем элемент
        spinnerFigure.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerFigure.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionFigure, long idFigure) {

                positionFigure1 = positionFigure;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________ЗАПОЛНЕНИЕ__________________

        spinnerFilling.setAdapter(adapterFilling);
        // заголовок
        spinnerFilling.setPrompt("Заполнение");
        // выделяем элемент
        spinnerFilling.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerFilling.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionFilling, long idFilling) {

                positionFilling1 = positionFilling;

                //Если заполнение сендвичем 100 или 50 процентов и не саламандер
                //Стеклопакет ставится на 32 мм
                if ( (positionFilling1 == 1 || positionFilling1 == 2) && !salamander) {
                    positionTypeOfGlass1 = 1;
                    spinnerTypeOfGlass.setSelection(1);
                }
                //Если заполнение сендвичем стекло 100 или 50 процентов
                //Показывается возможность выбора стекла
                if (positionFilling == 0 || positionFilling == 2) {
                    spinnerGlassDif.setVisibility(View.VISIBLE);
                    listGlassDif.setVisibility(View.VISIBLE);
                }
                //Если заполение сендвичем 100, скрывается возможность выбора стекла и все обновляется
                if (positionFilling == 1) {
                    glassPriceItems[0] = 0.0;
                    glassPriceItems[1] = 0.0;
                    glassPriceItems[2] = 0.0;
                    glassPriceItems[3] = 0.0;
                    adapterGlassDifLst.clear();
                    adapterGlassDifLst.add("Обычное стекло");
                    adapterGlassDifLst.add("Обычное стекло");
                    adapterGlassDifLst.add("Обычное стекло");
                    spinnerGlassDif.setVisibility(View.INVISIBLE);
                    listGlassDif.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________ШТУЛЬП__________________

        spinnerShtulp.setAdapter(adapterShtulp);
        // заголовок
        spinnerShtulp.setPrompt("Заполнение");
        // выделяем элемент
        spinnerShtulp.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerShtulp.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionShtulp, long idShtulp) {

                positionShtulp1 = positionShtulp;

                //Если выбирается штульп, фурнитура ставится ROTO
                if (positionShtulp1 == 1) {
                    positionFurnit1 = 1;
                    spinnerFurnit.setSelection(1);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________ВЫСОТА__________________

        spinnerHight.setAdapter(adapterHight);
        // заголовок
        spinnerHight.setPrompt("Высота");
        // выделяем элемент
        spinnerHight.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerHight.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionHight, long idHight) {

                positionHight1 = positionHight;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//__________________ШИРИНА_____________________

        spinnerWidth.setAdapter(adapterWidth);
        // заголовок
        spinnerWidth.setPrompt("Ширина");
        // выделяем элемент
        spinnerWidth.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerWidth.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionWidth, long idWidth) {

                positionWidth1 = positionWidth;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________ЛАМИНАЦИЯ_______________

        spinnerLamination.setAdapter(adapterLamination);
        // заголовок
        spinnerLamination.setPrompt("Ламинация");
        // выделяем элемент
        spinnerLamination.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerLamination.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionLamination, long idLamination) {

                positionLamination1 = positionLamination;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//________________РЕГИОН_________________________________________

        spinnerRegion.setAdapter(adapterRegion);
        // заголовок
        spinnerRegion.setPrompt("Регион");
        // выделяем элемент
        spinnerRegion.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerRegion.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionRegion, long idRegion) {

                positionRegion1 = positionRegion;
                if(MainActivity.hashMap.get(MainActivity.nameMeasure).getRegion()) {
                    spinnerRegion.setSelection(0);
                }else {
                    spinnerRegion.setSelection(1);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//________________________ШПРОСЫ_________________________________________

        spinnerShpros.setAdapter(adapterShpros);
        // заголовок
        spinnerShpros.setPrompt("Шпросы");
        // выделяем элемент
        spinnerShpros.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerShpros.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionShpros, long idShpros) {

                positionShpros1 = positionShpros;
                //Если шпросы не выбраны, скрывается их длина
                if (positionShpros1 == 0) {
                    positionShprosWidth1 = 0;
                    spinnerShprosWidth.setSelection(0);
                    spinnerShprosWidth.setVisibility(View.INVISIBLE);
                }
                //Если выбраны, длина показывается
                else {
                    spinnerShprosWidth.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________________ДЛИНА ШПРОС_________________________________________

        spinnerShprosWidth.setAdapter(adapterShprosWidth);
        // заголовок
        spinnerShprosWidth.setPrompt("Шпросы");
        // выделяем элемент
        spinnerShprosWidth.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerShprosWidth.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionShprosWidth, long idShprosWidth) {

                positionShprosWidth1 = positionShprosWidth;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________________ТИП СТЕКЛА_________________________________________

        spinnerGlassDif.setAdapter(adapterGlassDif);
        // заголовок
        spinnerGlassDif.setPrompt("Шпросы");
        // выделяем элемент
        spinnerGlassDif.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerGlassDif.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionGlassDif, long idGlassDif) {

                positionGlassDif1 = positionGlassDif;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________________ТИП РУЧКИ_________________________________________

        spinnerHandle.setAdapter(adapterHandle);
        // заголовок
        spinnerHandle.setPrompt("Ручки");
        // выделяем элемент
        spinnerHandle.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerHandle.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionHandle, long idHandle) {

                positionHandle1 = positionHandle;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//---------------------------------ЛИСТЫ------------------------
        builder = new AlertDialog.Builder(AddWindowActivity.this);

        listGlassDif.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {

                builder.setTitle("Внимание!");
                builder.setMessage("Заменить " + dataGlassList.get(position) + " на " + dataGlassDif.get(positionGlassDif1) +"?");

                builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dataGlassList.set(position, dataGlassDif.get(positionGlassDif1));
                        adapterGlassDifLst.notifyDataSetInvalidated();
                        setGlassPriceItems(positionGlassDif1, position);
                    }
                });

                builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });

//---------------------------------КНОПКИ---------------------------------------------------
        setTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.startAnimation(animAlpha);

                getPriceFlag = true;
                setPrice(positionType1, positionTypeOfType1);
                setFurntitPrice();
                setLaminationCoefficient();
                setGlassPrice();
                setPriceFigure();
                setPriceHandle();
                setLam();
                setPriceShtulp();
                setPriceShpros();

                String itemName = dataType[positionType1] + dataTypeOfType.get(positionTypeOfType1) + "   " + dataHight.get(positionHight1) + "*" + dataWidth.get(positionWidth1) + "\n" + dataProfile.get(positionProfile1) + "/" + dataTypeOfGlass.get(positionTypeOfGlass1) + (positionTypeOfType1 > 0 ? dataFurnit.get(positionFurnit1) + "   " : "   ") + dataRegion.get(positionRegion1).substring(0, 1);
                String itemInfo = "Фигура окна: " + (positionFigure1 == 0 ? "обычная\n\n" : dataFigure.get(positionFigure1) + "\n\n") +
                        "Профиль: " + dataProfile.get(positionProfile1) + "/" + dataTypeOfGlass.get(positionTypeOfGlass1) + (positionTypeOfType1 > 0 || balDorFlag ? " " + dataFurnit.get(positionFurnit1) + "\n" : "\n") +
                                  dataType[positionType1] + " " + (positionType1 != 4 ? dataTypeOfType.get(positionTypeOfType1) + "\n" : dataFilling.get(positionFilling1) + "\n") +
                                  "В " + dataHight.get(positionHight1) + "*" + dataWidth.get(positionWidth1) + " Ш" + "\n" +
                        (positionLamination1 == 0 ? dataLamination.get(positionLamination1) : "Ламинация: " + dataLamination.get(positionLamination1)) + "\n" +
                                  (dataGlassList.size() > 0 ? (dataGlassList.size() > 2 ?
                                          (dataGlassList.get(0).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(0) + ";") +
                                          (dataGlassList.get(1).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(1) + ";") +
                                          (dataGlassList.get(2).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(2) + ";") + "\n" :
                                                (dataGlassList.get(0).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(0) + ";") +
                                                (dataGlassList.get(1).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(1) + ";") + "\n") : "\n") +
                                  (positionTypeOfType1 > 0 || balDorFlag ? (dataHandleList.size() > 2 ? dataHandleList.get(0) + "\n" + dataHandleList.get(1) + "\n" + dataHandleList.get(2) + "\n" :
                                          dataHandleList.get(0) + "\n" + dataHandleList.get(1) + "\n"): "") +
                                  (positionTypeOfType1 > 1 ? dataShtulp.get(positionShtulp1) + "\n" : "") +
                        (positionShpros1 > 0 ? dataShpros.get(positionShpros1) + " " + dataShprosWidth.get(positionShprosWidth1) : dataShpros.get(positionShpros1));

                //Если добавление не в блок из списка
                if(!addFromList) {
                    if (positionRegion1 == 0) {
                        ProductList.addProdLst(itemName, setRegionPrice(), itemInterest, 0, 0);
                        MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                    } else {
                        ProductList.addProdLst(itemName, setMinskPrice(), itemInterest, 0, 0);
                        MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, setMinskPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                    }

                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(100);
                    try {
                        writeHash(MainActivity.hashMap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //Если добавление в блок из списка
                else {
                    if (positionRegion1 == 0) {
                        ProductList.addProdLst(itemName, setRegionPrice(), itemInterest, 0, 0);
                        MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                    } else {
                        ProductList.addProdLst(itemName, setMinskPrice(), itemInterest, 0, 0);
                        MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, setMinskPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                    }

                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(100);
                    try {
                        writeHash(MainActivity.hashMap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    onBackPressed();
                }
            }
        });
//__________________________________________________________________________________-
        prodLstBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(prodListBut);
            }
        });
//__________________________________________________________________________________-
        addHandleBut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            v.startAnimation(animAlpha);
            setHandlePriceItems(positionHandle1);
            //Если выбирается 2-х сторонняя ручка
            if(balDorFlag && positionHandle1 == 6) {
                positionFurnit1 = 1;
                spinnerFurnit.setSelection(1);
            }
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);
        }
    });
    }
//-------------------------------------------------------------------------------------


    public void setPrice(int p1, int p2) {

        //Глухая
        if(p2 == 0 && flag == true) {
            gluhFlag = true;
            adapterFigure.clear();
            adapterFigure.addAll(addList(R.array.dtaFigure));

            adapterHandle.clear();
            adapterHandle.addAll(addList(R.array.dtaHandle1));
            handlePriceItems[0] = 0;
            handlePriceItems[1] = 0;
            handlePriceItems[2] = 0;
            adapterHandleLst.clear();
        }
        //Открываются
        if( (p2 == 1 || p2 == 2 || p2 == 3 || p2 == 4) && flag == true) {
            gluhFlag = false;
            adapterFigure.clear();
            adapterFigure.addAll(addList(R.array.dtaFigure2));

            adapterHandle.clear();
            adapterHandle.addAll(addList(R.array.dtaHandle2));
            handlePriceItems[0] = 0;
            handlePriceItems[1] = 0;
            handlePriceItems[2] = 0;
            adapterHandleLst.clear();
            adapterHandleLst.add("Ручка стндрт.(белая, коричневая)");
            adapterHandleLst.add("Комплект декоративных накладок (белый, коричневый)");
        }

        // 1 створка глухая
        if(p1 == 0 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta1));
                adapterHight.addAll(addList(R.array.Hight_1stNo));
                adapterWidth.addAll(addList(R.array.Width_1stNo));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) <= 800 && Integer.parseInt(dataWidth.get(positionWidth1)) <= 600 ) {
                    itemInterest = DopPrices.INTW1STV2;
                }

                else if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1000 ) {
                    itemInterest = DopPrices.INTW2ST;
                }
                else {
                    itemInterest = DopPrices.INTW1ST;
                }

                if (BB6024 == true) {
                    price = BB6024wind1stNo[positionHight1][positionWidth1];
                }
                else if (BB6032 == true){
                    price = BB6032wind1stNo[positionHight1][positionWidth1];
                }
            }
            return;
        }

        // 2 стоврки 2 глухие
        if(p1 == 1 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta2));
                adapterHight.addAll(addList(R.array.Hight_2stNo));
                adapterWidth.addAll(addList(R.array.Width_2stNo));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1700 ) {
                    itemInterest = DopPrices.INTW3ST;
                }
                else {
                    itemInterest = DopPrices.INTW2ST;
                }

                if (BB6024 == true) {
                    price = BB6024wind2stNo[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = BB6032wind2stNo[positionHight1][positionWidth1];
                }
            }
            return;
        }

        // 3 створки 3 глухие
        if(p1 == 2 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta3));
                adapterHight.addAll(addList(R.array.Hight_3stNo));
                adapterWidth.addAll(addList(R.array.Width_3stNo));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 2500 ) {
                    itemInterest = DopPrices.INTW4ST;
                }
                else {
                    itemInterest = DopPrices.INTW3ST;
                }

                if (BB6024 == true) {
                    price = BB6024wind3stNo[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = BB6032wind3stNo[positionHight1][positionWidth1];
                }
            }
            return;
        }
        // 1 створка 1 открывается
        if(p1 == 0 && p2 == 1) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta1));
                adapterHight.addAll(addList(R.array.Hight_1stOp));
                adapterWidth.addAll(addList(R.array.Width_1stOp));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) <= 800 && Integer.parseInt(dataWidth.get(positionWidth1)) <= 600 ) {
                    itemInterest = DopPrices.INTW1STV2;
                }

                else if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1000 ) {
                    itemInterest = DopPrices.INTW2ST;
                }
                else {
                    itemInterest = DopPrices.INTW1ST;
                }

                if (BB6024 == true) {
                    price = BB6024wind1stOp[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = BB6032wind1stOp[positionHight1][positionWidth1];
                }
            }
            return;
        }
        // 2 створки 1 открывается
        if(p1 == 1 && p2 == 1) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta2));
                adapterHight.addAll(addList(R.array.Hight_2st1Op));
                adapterWidth.addAll(addList(R.array.Width_2st1Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1700 ) {
                    itemInterest = DopPrices.INTW3ST;
                }
                else {
                    itemInterest = DopPrices.INTW2ST;
                }

                if (BB6024 == true) {
                    price = BB6024wind2st1Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = BB6032wind2st1Op[positionHight1][positionWidth1];
                }
            }
            return;
        }

        // 2 створки 2 открывается
        if(p1 == 1 && p2 == 2) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta2));
                adapterHight.addAll(addList(R.array.Hight_2st2Op));
                adapterWidth.addAll(addList(R.array.Width_2st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1700 ) {
                    itemInterest = DopPrices.INTW3ST;
                }
                else {
                    itemInterest = DopPrices.INTW2ST;
                }

                if (BB6024 == true) {
                    price = BB6024wind2st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = BB6032wind2st2Op[positionHight1][positionWidth1];
                }
            }
            return;
        }

        // 3 створки 1 открывается
        if(p1 == 2 && p2 == 1) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta3));
                adapterHight.addAll(addList(R.array.Hight_3st1Op));
                adapterWidth.addAll(addList(R.array.Width_3st1Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 2500 ) {
                    itemInterest = DopPrices.INTW4ST;
                }
                else {
                    itemInterest = DopPrices.INTW3ST;
                }

                if (BB6024 == true) {
                    price = BB6024wind3st1Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = BB6032wind3st1Op[positionHight1][positionWidth1];
                }
            }
            return;
        }

        // 3 створки 2 открывается
        if(p1 == 2 && p2 == 2) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta3));
                adapterHight.addAll(addList(R.array.Hight_3st2Op));
                adapterWidth.addAll(addList(R.array.Width_3st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 2500 ) {
                    itemInterest = DopPrices.INTW4ST;
                }
                else {
                    itemInterest = DopPrices.INTW3ST;
                }

                if (BB6024 == true) {
                    price = BB6024wind3st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = BB6032wind3st2Op[positionHight1][positionWidth1];
                }
            }
            return;
        }

        // 3 створки 3 открывается
        if(p1 == 2 && p2 == 3) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta3));
                adapterHight.addAll(addList(R.array.Hight_3st2Op));
                adapterWidth.addAll(addList(R.array.Width_3st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 2500 ) {
                    itemInterest = DopPrices.INTW4ST;
                }
                else {
                    itemInterest = DopPrices.INTW3ST;
                }

                if (BB6024 == true) {
                    price = 25 + BB6024wind3st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = 25 + BB6032wind3st2Op[positionHight1][positionWidth1];
                }
            }
            return;
        }

        // 4 створки глухая
        if(p1 == 3 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterHight.addAll(addList(R.array.Hight_4st2Op));
                adapterWidth.addAll(addList(R.array.Width_4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = DopPrices.INTW4STV2;
                }
                else {
                    itemInterest = DopPrices.INTW4ST;
                }

                if (BB6024 == true) {
                    price = BB6024wind4st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = BB6032wind4st2Op[positionHight1][positionWidth1];
                }
            }
            return;
        }

        // 4 створки 1 открывается
        if(p1 == 3 && p2 == 1) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterHight.addAll(addList(R.array.Hight_4st2Op));
                adapterWidth.addAll(addList(R.array.Width_4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = DopPrices.INTW4STV2;
                }
                else {
                    itemInterest = DopPrices.INTW4ST;
                }

                if (BB6024 == true) {
                    price = BB6024wind4st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = BB6032wind4st2Op[positionHight1][positionWidth1];
                }
            }
            return;
        }

        // 4 створки 2 открывается
        if(p1 == 3 && p2 == 2) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterHight.addAll(addList(R.array.Hight_4st2Op));
                adapterWidth.addAll(addList(R.array.Width_4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = DopPrices.INTW4STV2;
                }
                else {
                    itemInterest = DopPrices.INTW4ST;
                }

                if (BB6024 == true) {
                    price = BB6024wind4st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = BB6032wind4st2Op[positionHight1][positionWidth1];
                }
            }
            return;
        }

        // 4 створки 3 открывается
        if(p1 == 3 && p2 == 3) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterHight.addAll(addList(R.array.Hight_4st2Op));
                adapterWidth.addAll(addList(R.array.Width_4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = DopPrices.INTW4STV2;
                }
                else {
                    itemInterest = DopPrices.INTW4ST;
                }

                if (BB6024 == true) {
                    price = 25 + BB6024wind4st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = 25 + BB6032wind4st2Op[positionHight1][positionWidth1];
                }
            }
            return;
        }

        // 4 створки 4 открывается
        if(p1 == 3 && p2 == 4) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterHight.addAll(addList(R.array.Hight_4st2Op));
                adapterWidth.addAll(addList(R.array.Width_4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = DopPrices.INTW4STV2;
                }
                else {
                    itemInterest = DopPrices.INTW4ST;
                }

                if (BB6024 == true) {
                    price = 50 + BB6024wind4st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = 50 + BB6032wind4st2Op[positionHight1][positionWidth1];
                }
            }
            return;
        }

        //Балконная дверь
        if(p1 == 4 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta5));
                adapterHight.addAll(addList(R.array.Hight_balDor));
                adapterWidth.addAll(addList(R.array.Width_balDor));
                flag = false;
                balDorFlag = true;

                adapterHandle.clear();
                adapterHandle.addAll(addList(R.array.dtaHandle3));
                handlePriceItems[0] = 0;
                handlePriceItems[1] = 0;
                handlePriceItems[2] = 0;
                adapterHandleLst.clear();
                adapterHandleLst.add("Ручка стндрт.(белая, коричневая)");
                adapterHandleLst.add("Комплект декоративных накладок (белый, коричневый)");
                adapterHandleLst.add("Хваталка балконная (белая, коричневая)");
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = DopPrices.INTBALDOR;

                if (BB6024 == true) {
                    price = BB6024balDor[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = BB6032balDor[positionHight1][positionWidth1];
                }
            }
            return;
        }

    }

    //_____________________________________________________________________________________
    public void setProfile(int p1, int p2) {

        salamander = false;

        //Если 24мм стекло
        if (p2 == 0) {
            glassPriceItems[0] = 0.0;
            glassPriceItems[1] = 0.0;
            glassPriceItems[2] = 0.0;
            glassPriceItems[3] = 0.0;
            adapterGlassDifLst.clear();
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            //adapterGlassDifLst.add("Кислород");
        }
        //Если 32мм или 40мм стекло
        if (p2 == 1 || p2 == 2) {
            glassPriceItems[0] = 0.0;
            glassPriceItems[1] = 0.0;
            glassPriceItems[2] = 0.0;
            glassPriceItems[3] = 0.0;
            adapterGlassDifLst.clear();
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            //adapterGlassDifLst.add("Кислород");
        }
        // BB 60/24
        if(p1 == 0 && p2 == 0) {
            BB6024 = true;
            BB6032 = false;
            profileCoefficient = DopPrices.BB6024W;

            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass60));
            return;
        }

        // BB 60/32
        if(p1 == 0 && p2 == 1) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = DopPrices.BB6032W;
            return;
        }

        // BB 70/24
        if(p1 == 1 && p2 == 0) {
            BB6024 = true;
            BB6032 = false;
            profileCoefficient = DopPrices.BB7024W;

            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass70));
            return;
        }

        // BB 70/32
        if(p1 == 1 && p2 == 1) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = DopPrices.BB7032W;
            return;
        }


        // BB 70/40
        if(p1 == 1 && p2 == 2) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = DopPrices.BB7040W;
            return;
        }


        // Rehau 60/24
        if(p1 == 2 && p2 == 0) {
            BB6024 = true;
            BB6032 = false;
            profileCoefficient = DopPrices.REHAU6024W;

            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass60));
            return;
        }


        // Rehau 60/32
        if(p1 == 2 && p2 == 1) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = DopPrices.REHAU6032W;
            return;
        }


        // Rehau 70/24
        if(p1 == 3 && p2 == 0) {
            BB6024 = true;
            BB6032 = false;
            profileCoefficient = DopPrices.REHAU7024W;

            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass70));
            return;
        }


        // Rehau 70/32
        if(p1 == 3 && p2 == 1) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = DopPrices.REHAU7032W;
            return;
        }


        // Rehau 70/40
        if(p1 == 3 && p2 == 2) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = DopPrices.REHAU7040W;
            return;
        }

        // Salamander 76/32
        if(p1 == 4 && p2 == 0) {
            profileCoefficient = DopPrices.SALAMANDER7032W;
            BB6024 = false;
            BB6032 = true;
            salamander = true;
            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass76));

            glassPriceItems[0] = 0.0;
            glassPriceItems[1] = 0.0;
            glassPriceItems[2] = 0.0;
            glassPriceItems[3] = 0.0;
            adapterGlassDifLst.clear();
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            return;
        }

        // Salamander 76/40
        if(p1 == 4 && p2 == 1) {
            BB6024 = false;
            BB6032 = true;
            salamander = true;
            profileCoefficient = DopPrices.SALAMANDER7040W;

            glassPriceItems[0] = 0.0;
            glassPriceItems[1] = 0.0;
            glassPriceItems[2] = 0.0;
            glassPriceItems[3] = 0.0;
            adapterGlassDifLst.clear();
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            return;
        }

    }
    //----------------------------------------------------------------------------
    public void setFurntitPrice(){

        furnitPrice = 0;

        if (positionFurnit1 == 1 && balDorFlag != true) {
            furnitPrice = DopPrices.rotoW * positionTypeOfType1;
        }
        if (positionFurnit1 == 1 && balDorFlag == true) {
            furnitPrice = DopPrices.rotoBD;
        }
    }
    //______________________________________________________
    public void setLaminationCoefficient(){

            //Если без ламинации
            if (positionLamination1 == 0) {
                laminationCoefficient = 1;
            }

            //Если ламинация с одной стороны
            else if (positionLamination1 == 1) {

                //БРУСБОКС 60
                if(positionProfile1 == 0) {
                    laminationCoefficient = DopPrices.lamWBB60_1st;
                }
                //БРУСБОКС 70
                else if(positionProfile1 == 1) {
                    laminationCoefficient = DopPrices.lamWBB70_1st;
                }
                //REHAU\SALAMANDER
                else {
                    laminationCoefficient = DopPrices.lamWRS_1st;
                }
            }

            //Если ламинация с 2 сторон
            else {
                //БРУСБОКС 60
                if(positionProfile1 == 0) {
                    laminationCoefficient = DopPrices.lamWBB60_2st;
                }
                //БРУСБОКС 70
                else if(positionProfile1 == 1) {
                    laminationCoefficient = DopPrices.lamWBB70_2st;
                }
                //REHAU\SALAMANDER
                else {
                    laminationCoefficient = DopPrices.lamWRS_2st;
                }
            }

    }
    //____________________________________________________________
    public double setRegionPrice(){
        return Math.ceil(((((price + furnitPrice + priceFigure + priceShtulp)* profileCoefficient)*laminationCoefficient) + lam + shpros + priceHandle + priceGlass));
    }

    public double setMinskPrice() {
        return Math.ceil(((((price + furnitPrice + priceFigure + priceShtulp) * profileCoefficient) * laminationCoefficient) + lam + shpros + priceHandle + priceGlass)*1.05);
    }

    public List<String> addList(@ArrayRes int id) {
        return Arrays.asList(getResources().getStringArray(id));
    }

    public void setGlassPriceItems(int p1, int p2) {
        //Вызывается при нажатии на эелемент листа
        //p1 - тип стекла
        //p2 - Позиция стекла в лсите

        //Обычное стекло
        if (p1 == 0) {
            glassPriceItems[p2] = 0.0;
            return;
        }
        //Мультик простой
        if (p1 == 1) {
            glassPriceItems[p2] = DopPrices.multik;
            return;
        }
        //Бронза в массе
        if (p1 == 2) {
            glassPriceItems[p2] = DopPrices.bronza;
            return;
        }
        //Матовое заводское
        if (p1 == 3) {
            glassPriceItems[p2] = DopPrices.mat;
            return;
        }
        //Тонировка пленка
        if (p1 == 4) {
            glassPriceItems[p2] = DopPrices.tonirovka;
            return;
        }
    }

    public void setGlassPrice() {
        //Вызывается после нажатия на кнопку добавить изделие
        double glass1;
        double glass2;
        double glass3;
        glass1 = ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * glassPriceItems[0];
        glass2 = ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * glassPriceItems[1];
        glass3 = ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * glassPriceItems[2];
        if (positionFilling1 == 0) {
            priceGlass = glass1 + glass2 + glass3;
        }else {
            priceGlass = glass1 + glass2 + glass3;
            priceGlass /= 2;
        }
    }

    public void setPriceFigure() {
        //Вызывается после нажатия на кнопку добавить изделие

        //Если окно глухое
        if (gluhFlag) {
            //Обычное окно
            if (positionFigure1 == 0) {
                priceFigure = 0;
            }
            //Арка
            else if (positionFigure1 == 1) {
                priceFigure = DopPrices.arka;
            }
            //Трапеция 2 угла
            else if (positionFigure1 == 2) {
                priceFigure = DopPrices.trapecija * 2;
            }
            //Трапеция 3 угла
            else if (positionFigure1 == 3) {
                priceFigure = DopPrices.trapecija * 3;
            }
            //Трапеция 4 угла
            else {
                priceFigure = DopPrices.trapecija * 4;
            }
        }
        else {
            //Обычное окно
            if (positionFigure1 == 0) {
                priceFigure = 0;
            }
            //Арка
            else{
                priceFigure = DopPrices.arka + (Integer.parseInt(dataWidth.get(positionWidth1))/1000.0 * 10);
            }
        }
    }

    public void setHandlePriceItems(int p1) {
        //Вызывется после нажатия на кнопку +
        //p1 - Тип ручки

        //Ручка [0]
        //Комплект накладок [1]
        //Хваталка балконная [2]


        //Если открываются окна
        if(!gluhFlag) {

            //Если выбраны ручки
            if(p1 == 0 || p1 == 1 || p1 == 2 || p1 == 3 || p1 == 4 || p1 == 5 || p1 == 6 || p1 == 7) {
                dataHandleList.set(0, dataHandle.get(positionHandle1));
            }
            //Если выбраны накладки
            else{
                dataHandleList.set(1, dataHandle.get(positionHandle1));
            }
            adapterHandleLst.notifyDataSetInvalidated();

            //Ручка стндрт.
            if(p1 == 0) {
                handlePriceItems[0] = 0;
            }
            //Ручка Roto Samba (белая)
            else if(p1 == 1) {
                handlePriceItems[0] = DopPrices.ruchkaSambaBel;
            }
            //Ручка Hoppe (коричневая)
            else if(p1 == 2) {
                handlePriceItems[0] = DopPrices.ruchkaHopeKorich;
            }
            //Ручка Roto Line (белая, латунь, серо-коричневая, бронза, серебро, шампань, титан, темная бронза)
            else if(p1 == 3) {
                handlePriceItems[0] = DopPrices.ruchkaRotoLine;
            }
            //Ручка Roto Swing (белая, серебро, титан мат)
            else if(p1 == 4) {
                handlePriceItems[0] = DopPrices.ruchkaRotoSwingV1;
            }
            //Ручка Roto Swing (черно-коричневая, новое серебро, латунь мат, бронза, темная бронза)
            else if(p1 == 5) {
                handlePriceItems[0] = DopPrices.ruchkaRotoSwingV2;
            }
            //Ручка 2-х сторонняя (белая, коричневая)
            else if(p1 == 6) {
                handlePriceItems[0] = DopPrices.ruchka2storon;
            }
            //Ручка с ключом (белая, коричневая)
            else if(p1 == 7) {
                handlePriceItems[0] = DopPrices.ruchkaSKluchom;
            }
            //Комплект декоративных накладок (белый, коричневый)
            else if(p1 == 8) {
                handlePriceItems[1] = 0;
            }
            //Комплект декоративных накладок (цветной)
            else {
                handlePriceItems[1] = DopPrices.dekorNakladkaCvet;
            }
        }

        //Если балконная дверь
        else if(balDorFlag) {
            //Если выбраны ручки
            if(p1 == 0 || p1 == 1 || p1 == 2 || p1 == 3 || p1 == 4 || p1 == 5 || p1 == 6 || p1 == 7) {
                dataHandleList.set(0, dataHandle.get(positionHandle1));
                adapterHandleLst.notifyDataSetInvalidated();
            }
            //Если выбраны хваталки
            else if (p1 == 8 || p1 == 9){
                dataHandleList.set(2, dataHandle.get(positionHandle1));
                adapterHandleLst.notifyDataSetInvalidated();
            }
            //Если выбраны накладки
            else {
                dataHandleList.set(1, dataHandle.get(positionHandle1));
                adapterHandleLst.notifyDataSetInvalidated();
            }

            //Ручка стндрт.
            if(p1 == 0) {
                handlePriceItems[0] = 0;
            }
            //Ручка Roto Samba (белая)
            else if(p1 == 1) {
                handlePriceItems[0] = DopPrices.ruchkaSambaBel;
            }
            //Ручка Hoppe (коричневая)
            else if(p1 == 2) {
                handlePriceItems[0] = DopPrices.ruchkaHopeKorich;
            }
            //Ручка Roto Line (белая, латунь, серо-коричневая, бронза, серебро, шампань, титан, темная бронза)
            else if(p1 == 3) {
                handlePriceItems[0] = DopPrices.ruchkaRotoLine;
            }
            //Ручка Roto Swing (белая, серебро, титан мат)
            else if(p1 == 4) {
                handlePriceItems[0] = DopPrices.ruchkaRotoSwingV1;
            }
            //Ручка Roto Swing (черно-коричневая, новое серебро, латунь мат, бронза, темная бронза)
            else if(p1 == 5) {
                handlePriceItems[0] = DopPrices.ruchkaRotoSwingV2;
            }
            //Ручка 2-х сторонняя (белая, коричневая)
            else if(p1 == 6) {
                handlePriceItems[0] = DopPrices.ruchka2storon;
            }
            //Ручка с ключом (белая, коричневая)
            else if(p1 == 7) {
                handlePriceItems[0] = DopPrices.ruchkaSKluchom;
            }
            //Хваталка балконная (белая, коричневая)
            else if(p1 == 8) {
                handlePriceItems[2] = 0;
            }
            //Хваталка балконная (антрацит, золотой дуб)
            else if(p1 == 9) {
                handlePriceItems[2] = DopPrices.hvatalkaCvet;
            }
            //Комплект декоративных накладок (белый, коричневый)
            else if(p1 == 10) {
                handlePriceItems[1] = 0;
            }
            //Комплект декоративных накладок (цветной)
            else  {
                handlePriceItems[1] = DopPrices.dekorNakladkaCvet;
            }
        }
    }

    public void setPriceHandle() {
        //Вызывается после нажатия на кнопку добавить изделие

        if (!balDorFlag) {
            priceHandle = (handlePriceItems[0] * positionTypeOfType1) + handlePriceItems[1];
        } else {
            priceHandle = handlePriceItems[0] + handlePriceItems[1] + handlePriceItems[2];
        }

    }

    public void setLam() {
        //Вызывается после нажатия на кнопку добавить изделие
        lam = 0;

        //Только если выбрана балконная дверь
        if (balDorFlag) {
            //Только если выбрана ламинация
            if (positionLamination1 == 1 || positionLamination1 == 2) {
                //Если заполнение стеклом 100%
                if (positionFilling1 == 0) {
                    lam = 0;
                    return;
                }
                //Если заполнение сендвичем 100% или 50/50
                if (positionFilling1 != 0) {
                    //Если ламинация с одной стороны и заполнение сендвичем 100% или ламинация с двух сторон и заполнение 50/50
                    if( (positionLamination1 == 1 && positionFilling1 == 1) || (positionLamination1 == 2 && positionFilling1 == 2) ) {
                        lam = ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * DopPrices.lamSend;
                        return;
                    }
                    //Если ламинация с 2 сторон и заполнение сендвичем 100%
                    if (positionLamination1 == 2 && positionFilling1 == 1) {
                        lam = ( ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * DopPrices.lamSend ) * 2;
                        return;
                    }
                    //Если ламинация с 1 тороны и заполнение сендвичем 50/50
                    if (positionLamination1 == 1 && positionFilling1 == 2) {
                        lam = ( ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * DopPrices.lamSend ) / 2;
                        return;
                    }
                }


            }
        }
    }

    public void setPriceShtulp() {
        //Вызывается после нажатия на кнопку добавить изделие

        if (positionShtulp1 == 0) {
            priceShtulp = 0;
        } else {
            priceShtulp = DopPrices.shtulp;
        }

    }
    public void setPriceShpros() {
        //Вызывается после нажатия на кнопку добавить изделие

        //Без шпрос
        if (positionShpros1 == 0) {
            shpros = 0;
        }
        //Шпросы белые/коричневые 26мм
        else if (positionShpros1 == 1) {
            shpros = (Double.parseDouble(dataShprosWidth.get(positionShprosWidth1)) / 1000) * DopPrices.shprosBelKor26mm;
        }
        //Шпросы белые/коричневые 18мм
        else if (positionShpros1 == 2) {
            shpros = (Double.parseDouble(dataShprosWidth.get(positionShprosWidth1)) / 1000) * DopPrices.shprosBelKor18mm;
        }
        //Шпросы белые/золотые 8мм
        else {
            shpros = (Double.parseDouble(dataShprosWidth.get(positionShprosWidth1)) / 1000) * DopPrices.shprosBelZol8mm;
        }
    }

    public void writeHash(LinkedHashMap<String, Measure> wHashMap) throws IOException {
        Gson gson = new Gson();
        FileOutputStream fos = null;

        String json = gson.toJson(wHashMap);
        json = gson.toJson(ContinePrice.compress(json));
        fos = new FileOutputStream(getExternalPath());
        fos.write(json.getBytes());
    }
    private File getExternalPath() {
        return new File(getExternalFilesDir(null), MainActivity.fileName);
    }
//__________________________________________________________________________________________________

    //Если false - стандартный запуск
    //Если true - запуск из листа
    public static void setAddFromList(boolean b) {
        addFromList = b;
    }

    //Переопределяем кнопку назад
    @Override
    public void onBackPressed() {
        //Если добавили новое изделие зайдя из списка, или нажали назад
        if (addFromList) {
            setAddFromList(false);
            ProductList.setAddFromList(false);
            getOnBackPressedDispatcher().onBackPressed();
        }
        //Если заходили обычно
        else {
            getOnBackPressedDispatcher().onBackPressed();
        }
    }
}
