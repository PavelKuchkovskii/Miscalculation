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

    static int [][] BB6024wind1stNo = { {9, 10, 11, 12, 13, 13, 14, 15, 16, 17, 18, 19, 20, 21, 21},
            {9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 25},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 25, 27},
            {12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 25, 26, 27, 28},
            {12, 13, 15, 16, 17, 19, 20, 21, 22, 23, 25, 27, 28, 29, 30},
            {13, 14, 16, 17, 19, 20, 21, 22, 25, 26, 27, 28, 30, 31, 32},
            {14, 15, 17, 18, 20, 21, 22, 25, 26, 27, 29, 30, 31, 33, 34},
            {15, 16, 18, 19, 21, 22, 25, 26, 27, 29, 30, 32, 33, 34, 36},
            {16, 17, 19, 20, 22, 23, 26, 27, 29, 30, 32, 33, 35, 36, 38},
            {16, 18, 20, 21, 23, 26, 27, 29, 30, 32, 33, 35, 36, 38, 40},
            {17, 19, 21, 22, 25, 27, 28, 30, 32, 33, 35, 36, 38, 41, 42},
            {18, 20, 22, 25, 26, 28, 30, 31, 33, 35, 36, 38, 41, 42, 44},
            {19, 21, 23, 26, 27, 29, 31, 33, 34, 36, 38, 41, 42, 44, 46},
            {20, 22, 25, 27, 28, 30, 32, 34, 36, 38, 41, 42, 44, 46, 48},
            {21, 22, 26, 28, 30, 31, 33, 35, 37, 40, 42, 44, 46, 48, 50},
            {21, 23, 27, 29, 31, 33, 35, 37, 40, 42, 44, 46, 48, 50, 52} };


    static int [][] BB6024wind1stOp = { {31, 32, 33, 35, 37, 41, 43, 45, 47, 48, 50},
            {32, 33, 35, 37, 40, 43, 45, 47, 49, 50, 52},
            {34, 35, 37, 40, 41, 45, 47, 49, 51, 53, 54},
            {35, 36, 38, 41, 43, 46, 49, 51, 53, 56, 58},
            {37, 38, 41, 43, 45, 48, 50, 53, 56, 58, 60},
            {41, 42, 44, 46, 48, 52, 54, 57, 60, 62, 64},
            {43, 44, 46, 48, 50, 54, 57, 59, 62, 64, 66},
            {44, 45, 48, 50, 52, 57, 59, 62, 64, 66, 68},
            {46, 47, 49, 52, 54, 59, 61, 63, 66, 68, 70},
            {48, 49, 51, 54, 57, 61, 63, 66, 68, 72, 74},
            {49, 50, 53, 56, 59, 63, 65, 68, 70, 74, 76},
            {51, 52, 54, 58, 60, 64, 67, 70, 73, 76, 78},
            {55, 56, 58, 61, 63, 68, 70, 74, 77, 79, 82},
            {56, 57, 60, 63, 65, 69, 73, 76, 79, 81, 84},
            {58, 59, 61, 64, 67, 72, 75, 78, 81, 84, 87} };


    static int [][] BB6024wind2st1Op = { {45, 46, 47, 48, 49, 51, 52, 54, 56, 58, 61, 62, 64, 65, 67},
            {47, 48, 49, 50, 51, 53, 56, 57, 59, 60, 64, 65, 67, 68, 70},
            {49, 50, 51, 52, 54, 56, 58, 60, 62, 63, 66, 68, 70, 72, 74},
            {54, 55, 56, 57, 59, 60, 63, 64, 66, 68, 72, 73, 75, 77, 79},
            {56, 57, 58, 59, 61, 63, 65, 67, 68, 70, 75, 76, 78, 80, 82},
            {59, 60, 61, 62, 64, 66, 68, 70, 72, 74, 78, 79, 81, 83, 85},
            {61, 62, 63, 64, 66, 68, 70, 73, 75, 77, 80, 82, 84, 87, 90},
            {64, 65, 66, 67, 69, 72, 74, 76, 78, 80, 83, 85, 88, 91, 93},
            {66, 67, 68, 69, 72, 74, 76, 79, 81, 83, 87, 89, 91, 94, 96},
            {69, 70, 71, 72, 74, 76, 79, 81, 83, 85, 90, 92, 94, 97, 99},
            {73, 74, 75, 76, 78, 80, 83, 85, 88, 90, 94, 96, 98, 101, 104},
            {75, 76, 77, 78, 80, 83, 85, 89, 91, 93, 97, 99, 101, 105, 107},
            {77, 78, 79, 80, 83, 85, 89, 91, 93, 96, 100, 103, 105, 108, 110},
            {80, 81, 82, 83, 85, 88, 91, 94, 96, 98, 103, 106, 108, 111, 114},
            {82, 83, 84, 85, 89, 91, 94, 96, 99, 101, 106, 109, 111, 114, 117},
            {85, 86, 87, 88, 91, 93, 96, 99, 101, 105, 109, 112, 114, 117, 121} };

    static int [][] BB6024wind3st1Op = { {60, 61, 62, 63, 65, 66, 68, 69, 72, 73, 74, 77, 79, 80, 81},
            {63, 64, 65, 67, 68, 70, 72, 74, 75, 76, 78, 81, 82, 84, 85},
            {66, 67, 68, 70, 72, 74, 75, 77, 79, 80, 82, 85, 87, 89, 90},
            {71, 72, 74, 75, 77, 79, 80, 82, 84, 85, 88, 91, 93, 94, 96},
            {74, 75, 77, 79, 80, 82, 84, 85, 88, 90, 91, 95, 96, 98, 100},
            {78, 79, 80, 82, 84, 87, 88, 90, 92, 94, 95, 99, 100, 103, 105},
            {80, 81, 83, 85, 88, 90, 92, 94, 95, 97, 99, 103, 105, 107, 109},
            {84, 85, 88, 89, 91, 94, 95, 97, 99, 101, 104, 107, 109, 111, 113},
            {88, 89, 91, 93, 95, 97, 99, 101, 104, 106, 108, 111, 113, 115, 117},
            {91, 92, 94, 96, 98, 100, 103, 105, 107, 109, 111, 115, 117, 120, 122},
            {95, 96, 98, 100, 103, 106, 108, 110, 112, 114, 116, 121, 123, 125, 127},
            {98, 99, 101, 104, 106, 109, 111, 113, 115, 119, 121, 125, 127, 129, 131},
            {102, 103, 105, 107, 110, 112, 114, 117, 120, 122, 124, 128, 130, 133, 136},
            {105, 106, 108, 110, 113, 115, 119, 121, 123, 126, 128, 132, 135, 138, 140},
            {108, 109, 111, 114, 116, 120, 122, 125, 127, 130, 132, 137, 139, 142, 144},
            {111, 112, 115, 117, 120, 123, 126, 128, 131, 133, 137, 141, 143, 146, 148} };

    static int [][] BB6024wind4st2Op = { {108, 109, 110, 112, 114, 115, 117, 120, 122, 124, 125, 127, 129, 130, 132},
            {112, 113, 114, 116, 119, 121, 122, 124, 127, 128, 130, 132, 135, 136, 138},
            {118, 119, 120, 122, 124, 126, 128, 130, 132, 135, 137, 139, 140, 142, 144},
            {123, 124, 125, 127, 128, 130, 132, 135, 138, 140, 142, 143, 145, 147, 150},
            {127, 128, 129, 131, 133, 136, 138, 140, 143, 145, 147, 150, 152, 154, 156},
            {133, 134, 135, 137, 139, 141, 143, 145, 148, 151, 153, 155, 157, 159, 161},
            {137, 138, 139, 141, 143, 145, 147, 150, 153, 155, 158, 160, 162, 164, 167},
            {144, 145, 146, 148, 151, 153, 156, 158, 161, 163, 166, 168, 170, 173, 175},
            {149, 150, 151, 153, 156, 158, 160, 162, 166, 169, 171, 173, 175, 178, 180},
            {153, 154, 155, 158, 160, 162, 166, 168, 171, 173, 176, 178, 180, 184, 186},
            {158, 159, 160, 162, 164, 168, 170, 173, 176, 178, 182, 184, 186, 189, 191},
            {162, 163, 164, 168, 170, 173, 175, 178, 182, 184, 187, 189, 192, 194, 198},
            {168, 169, 170, 172, 175, 177, 180, 183, 187, 189, 192, 194, 198, 200, 203},
            {172, 173, 174, 176, 179, 183, 185, 188, 191, 194, 198, 200, 203, 205, 208} };

    static int [][] BB6024balDor = { {57, 58, 61, 64, 67, 72, 75, 78},
            {59, 60, 62, 66, 68, 74, 77, 80},
            {62, 63, 66, 69, 73, 78, 81, 84},
            {64, 65, 68, 72, 75, 79, 83, 87},
            {65, 66, 69, 74, 77, 81, 85, 89},
            {67, 68, 72, 75, 79, 83, 88, 91},
            {68, 69, 74, 77, 80, 85, 90, 93},
            {71, 72, 75, 79, 82, 88, 91, 95} };

    static int [][] BB6024wind2st2Op = { {64, 65, 66, 67, 69, 72, 74, 76, 78, 79, 84, 87, 89},
            {67, 68, 69, 70, 73, 75, 77, 79, 81, 83, 89, 90, 92},
            {71, 72, 73, 74, 76, 78, 80, 82, 84, 87, 92, 94, 96},
            {77, 78, 79, 80, 82, 84, 88, 90, 92, 94, 99, 101, 103},
            {80, 81, 82, 83, 85, 88, 91, 93, 95, 97, 103, 105, 107},
            {84, 85, 86, 87, 89, 92, 94, 96, 99, 101, 107, 109, 111},
            {87, 88, 89, 90, 92, 95, 97, 100, 103, 105, 110, 112, 115},
            {91, 92, 93, 94, 96, 98, 101, 104, 107, 109, 114, 116, 120},
            {93, 94, 95, 96, 99, 101, 105, 107, 110, 112, 117, 121, 123},
            {96, 97, 98, 99, 103, 105, 108, 110, 113, 115, 122, 124, 126},
            {103, 104, 105, 106, 108, 111, 114, 116, 120, 122, 128, 130, 133},
            {105, 106, 107, 108, 111, 114, 117, 120, 123, 125, 131, 135, 137},
            {108, 109, 110, 111, 114, 117, 121, 123, 126, 129, 135, 138, 141} };

    static int [][] BB6024wind3st2Op = { {80, 81, 82, 83, 85, 87, 90, 91, 93, 94, 96, 97, 103, 105, 106},
            {83, 84, 85, 88, 90, 91, 94, 95, 97, 98, 100, 103, 107, 109, 111},
            {88, 89, 90, 92, 93, 95, 97, 99, 101, 104, 105, 107, 112, 113, 115},
            {95, 96, 97, 99, 100, 103, 106, 107, 109, 111, 113, 115, 120, 122, 124},
            {98, 99, 100, 103, 105, 107, 110, 111, 113, 115, 117, 120, 125, 127, 128},
            {104, 105, 106, 108, 110, 112, 114, 116, 119, 121, 123, 125, 130, 132, 135},
            {107, 108, 109, 111, 113, 115, 119, 121, 123, 125, 127, 129, 135, 137, 139},
            {112, 113, 114, 116, 119, 121, 124, 126, 128, 130, 132, 135, 140, 142, 144},
            {115, 116, 117, 120, 122, 125, 127, 130, 132, 135, 137, 139, 144, 146, 150},
            {120, 121, 122, 124, 126, 128, 131, 133, 137, 139, 141, 143, 150, 152, 154},
            {126, 127, 128, 130, 133, 136, 139, 141, 143, 146, 148, 151, 157, 159, 161},
            {130, 131, 132, 135, 137, 140, 143, 145, 147, 151, 153, 156, 161, 163, 167},
            {134, 135, 136, 139, 141, 144, 147, 150, 153, 155, 157, 160, 166, 169, 171},
            {138, 139, 140, 142, 145, 147, 152, 154, 157, 159, 162, 164, 171, 173, 176},
            {142, 143, 144, 146, 150, 153, 156, 159, 161, 164, 167, 170, 175, 178, 182},
            {145, 146, 147, 151, 154, 156, 160, 162, 166, 169, 171, 174, 180, 183, 186} };

    static int [][] BB6024wind2stNo = { {16, 17, 18, 19, 20, 21, 22, 23, 25, 26, 27, 28, 29, 30, 31},
            {17, 18, 20, 21, 22, 23, 25, 26, 27, 28, 29, 30, 31, 32, 33},
            {19, 20, 21, 22, 23, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35},
            {20, 21, 22, 25, 26, 27, 28, 29, 30, 32, 33, 34, 35, 36, 38},
            {21, 22, 25, 26, 27, 29, 30, 31, 32, 34, 35, 36, 37, 40, 41},
            {22, 25, 26, 27, 29, 30, 31, 33, 34, 35, 37, 38, 40, 42, 43},
            {25, 26, 28, 29, 30, 32, 33, 35, 36, 37, 40, 41, 43, 44, 45},
            {26, 27, 29, 30, 32, 33, 35, 36, 38, 40, 42, 43, 45, 46, 48},
            {27, 29, 30, 32, 33, 35, 37, 38, 41, 42, 44, 45, 47, 48, 50},
            {28, 30, 32, 33, 35, 37, 38, 41, 42, 44, 46, 47, 49, 51, 52},
            {30, 31, 33, 35, 37, 38, 41, 43, 44, 46, 48, 49, 51, 53, 54},
            {31, 33, 35, 36, 38, 41, 43, 44, 46, 48, 50, 51, 53, 56, 58},
            {32, 34, 36, 38, 41, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60},
            {34, 35, 37, 40, 42, 44, 46, 48, 50, 52, 54, 57, 58, 60, 62},
            {35, 37, 40, 42, 44, 46, 48, 50, 52, 54, 57, 59, 61, 63, 65},
            {36, 38, 41, 43, 45, 47, 49, 51, 54, 57, 59, 61, 63, 65, 67} };

    static int [][] BB6024wind3stNo = { {40, 41, 42, 43, 45, 46, 47, 48, 49, 51, 52, 53, 54, 56, 57},
            {42, 44, 45, 46, 47, 49, 50, 51, 52, 54, 56, 57, 58, 60, 61},
            {45, 46, 47, 49, 50, 51, 53, 54, 56, 58, 59, 60, 62, 63, 64},
            {47, 48, 50, 51, 53, 54, 56, 58, 59, 61, 62, 63, 65, 66, 68},
            {49, 51, 52, 54, 56, 58, 59, 61, 62, 64, 65, 67, 68, 69, 72},
            {52, 53, 56, 57, 59, 60, 62, 63, 65, 67, 68, 70, 72, 74, 75},
            {54, 57, 58, 60, 61, 63, 65, 66, 68, 70, 72, 74, 75, 77, 79},
            {57, 59, 61, 62, 64, 66, 67, 69, 72, 74, 75, 77, 79, 80, 82},
            {60, 61, 63, 65, 67, 69, 70, 73, 75, 77, 78, 80, 82, 84, 85},
            {62, 64, 66, 68, 69, 72, 74, 76, 78, 80, 81, 83, 85, 88, 90},
            {64, 66, 68, 70, 73, 75, 77, 79, 81, 83, 85, 87, 89, 91, 93},
            {67, 69, 72, 74, 76, 78, 80, 82, 84, 87, 89, 91, 93, 95, 97},
            {69, 72, 74, 76, 78, 80, 82, 84, 88, 90, 92, 94, 96, 98, 100},
            {72, 74, 77, 79, 81, 83, 85, 88, 90, 93, 95, 97, 99, 101, 104},
            {75, 77, 79, 81, 84, 87, 89, 91, 93, 96, 98, 100, 103, 105, 108},
            {77, 79, 82, 84, 87, 89, 92, 94, 96, 99, 101, 104, 106, 109, 111} };

//_____________________________60/32_____________________________________________________________

    static int [][] BB6032wind1stNo = { {8, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 26},
            {10, 12, 13, 14, 16, 17, 18, 19, 20, 22, 23, 25, 26, 27, 29},
            {12, 13, 15, 16, 17, 19, 20, 21, 23, 25, 26, 28, 29, 30, 32},
            {13, 14, 16, 17, 19, 20, 22, 23, 26, 27, 29, 30, 32, 33, 34},
            {14, 15, 17, 19, 20, 22, 25, 26, 28, 29, 31, 33, 34, 36, 37},
            {15, 16, 18, 20, 22, 25, 26, 28, 30, 32, 33, 35, 37, 40, 41},
            {16, 17, 20, 22, 23, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44},
            {17, 18, 21, 23, 26, 28, 30, 32, 34, 36, 38, 41, 43, 45, 47},
            {18, 20, 22, 25, 27, 30, 32, 34, 36, 38, 41, 43, 46, 48, 50},
            {19, 21, 23, 27, 29, 31, 34, 36, 38, 41, 44, 46, 48, 51, 53},
            {20, 22, 26, 28, 31, 33, 35, 38, 41, 44, 46, 48, 51, 53, 57},
            {21, 23, 27, 30, 32, 35, 37, 41, 43, 46, 48, 51, 54, 57, 60},
            {22, 25, 28, 31, 34, 36, 40, 43, 45, 48, 51, 53, 57, 60, 62},
            {23, 26, 30, 32, 35, 38, 42, 45, 47, 50, 53, 57, 60, 63, 65},
            {25, 27, 31, 34, 37, 41, 44, 47, 50, 52, 56, 59, 62, 65, 68},
            {26, 29, 32, 35, 38, 42, 45, 49, 52, 56, 59, 62, 65, 68, 72} };

    static int [][] BB6032wind1stOp = { {29, 33, 34, 37, 38, 43, 45, 47, 49, 51, 53},
            {32, 34, 36, 40, 42, 45, 47, 50, 52, 54, 57},
            {34, 36, 38, 42, 44, 47, 50, 52, 56, 58, 60},
            {35, 38, 41, 44, 46, 50, 52, 56, 58, 61, 63},
            {37, 41, 43, 46, 48, 52, 56, 58, 61, 64, 66},
            {40, 44, 47, 50, 52, 57, 60, 63, 65, 68, 72},
            {42, 46, 49, 52, 54, 59, 62, 65, 68, 72, 75},
            {45, 48, 51, 54, 58, 62, 65, 68, 72, 75, 78},
            {46, 50, 53, 57, 60, 64, 67, 72, 75, 78, 81},
            {48, 52, 56, 59, 62, 67, 70, 75, 78, 81, 84},
            {50, 54, 58, 61, 64, 69, 74, 77, 81, 84, 88},
            {51, 56, 60, 63, 67, 72, 76, 80, 83, 88, 91},
            {54, 60, 63, 67, 70, 76, 80, 84, 88, 92, 95},
            {57, 61, 65, 69, 73, 78, 82, 87, 91, 95, 98},
            {58, 63, 67, 72, 75, 81, 85, 90, 94, 98, 101} };

    static int [][] BB6032wind2st1Op = { {46, 47, 49, 51, 53, 56, 58, 60, 62, 63, 67, 69, 70, 74, 76},
            {49, 50, 52, 54, 57, 59, 61, 63, 65, 67, 70, 73, 75, 78, 80},
            {51, 52, 54, 57, 60, 62, 64, 66, 68, 70, 75, 77, 79, 82, 84},
            {56, 57, 60, 62, 64, 66, 69, 72, 74, 77, 81, 83, 85, 89, 91},
            {59, 60, 62, 65, 67, 69, 73, 76, 78, 80, 84, 88, 90, 93, 95},
            {62, 63, 65, 68, 70, 74, 77, 79, 82, 84, 89, 92, 94, 97, 100},
            {64, 65, 68, 70, 74, 77, 80, 82, 85, 89, 93, 96, 98, 101, 105},
            {67, 68, 72, 75, 77, 80, 83, 87, 90, 93, 97, 100, 104, 107, 110},
            {69, 70, 74, 77, 80, 83, 87, 90, 93, 96, 101, 105, 107, 111, 114},
            {73, 74, 77, 80, 83, 87, 91, 94, 97, 100, 105, 108, 111, 115, 119},
            {77, 78, 81, 84, 88, 92, 95, 98, 101, 106, 110, 114, 117, 121, 125},
            {79, 80, 84, 88, 91, 95, 98, 103, 106, 109, 114, 117, 122, 125, 129},
            {82, 83, 87, 91, 94, 98, 101, 106, 109, 113, 119, 122, 126, 129, 133},
            {84, 85, 90, 93, 97, 101, 105, 109, 113, 116, 122, 126, 130, 135, 138},
            {88, 89, 93, 96, 100, 105, 109, 113, 116, 121, 126, 130, 135, 139, 143},
            {90, 91, 95, 99, 104, 108, 112, 116, 121, 125, 130, 135, 139, 143, 147} };

    static int [][] BB6032wind3st1Op = { {63, 66, 68, 69, 72, 74, 76, 78, 80, 81, 83, 87, 89, 91, 93},
            {68, 70, 72, 74, 76, 79, 80, 82, 84, 87, 89, 92, 94, 96, 98},
            {72, 74, 76, 78, 80, 83, 85, 88, 90, 92, 94, 98, 100, 103, 105},
            {77, 80, 82, 84, 87, 90, 92, 94, 96, 98, 101, 105, 108, 110, 112},
            {82, 83, 87, 89, 91, 94, 96, 99, 101, 104, 107, 110, 113, 115, 117},
            {86, 89, 91, 93, 96, 99, 101, 105, 107, 109, 112, 116, 119, 122, 124},
            {89, 92, 95, 97, 100, 104, 106, 109, 112, 114, 117, 122, 125, 127, 130},
            {94, 96, 99, 103, 105, 109, 111, 114, 117, 120, 123, 127, 130, 133, 136},
            {98, 100, 104, 107, 110, 113, 116, 119, 122, 125, 128, 132, 136, 139, 142},
            {101, 105, 108, 111, 114, 117, 121, 124, 127, 130, 133, 138, 141, 144, 147},
            {107, 110, 113, 116, 120, 124, 127, 130, 133, 137, 140, 145, 148, 152, 155},
            {111, 114, 117, 121, 124, 128, 131, 135, 139, 142, 145, 151, 154, 158, 161},
            {115, 117, 122, 125, 129, 132, 137, 140, 143, 147, 151, 156, 159, 163, 167},
            {119, 122, 126, 129, 133, 138, 141, 145, 148, 153, 156, 161, 166, 169, 173},
            {123, 126, 130, 133, 138, 142, 146, 150, 154, 158, 161, 167, 171, 175, 178},
            {127, 130, 135, 138, 142, 146, 151, 155, 159, 162, 167, 173, 176, 180, 185} };

    static int [][] BB6032wind4st2Op = { {114, 117, 121, 123, 125, 127, 130, 132, 136, 138, 140, 143, 145, 147, 150},
            {120, 122, 126, 128, 131, 133, 136, 139, 142, 144, 147, 150, 152, 155, 157},
            {125, 129, 132, 135, 138, 140, 143, 145, 150, 152, 155, 157, 160, 162, 166},
            {131, 134, 138, 141, 143, 146, 150, 152, 156, 158, 161, 164, 167, 170, 173},
            {137, 141, 144, 147, 150, 153, 156, 159, 162, 166, 169, 172, 174, 177, 180},
            {143, 146, 150, 153, 156, 159, 162, 166, 169, 172, 175, 178, 182, 185, 188},
            {148, 151, 155, 158, 161, 164, 168, 171, 175, 178, 182, 185, 188, 192, 195},
            {156, 160, 163, 167, 171, 174, 177, 180, 185, 188, 191, 195, 199, 202, 205},
            {161, 166, 169, 173, 176, 179, 184, 187, 191, 194, 199, 202, 205, 209, 213},
            {167, 171, 175, 178, 182, 186, 189, 193, 198, 201, 205, 208, 213, 216, 220},
            {172, 176, 180, 184, 188, 192, 195, 200, 204, 208, 211, 216, 219, 223, 227},
            {179, 183, 186, 190, 194, 199, 202, 206, 211, 215, 219, 223, 226, 231, 235},
            {184, 188, 192, 197, 200, 204, 208, 213, 218, 221, 225, 230, 234, 238, 242},
            {190, 194, 198, 202, 206, 210, 215, 219, 224, 229, 233, 237, 241, 246, 250} };

    static int [][] BB6032balDor = { {57, 62, 65, 69, 74, 79, 83, 88},
            {58, 63, 67, 72, 76, 82, 87, 91},
            {61, 67, 72, 76, 80, 87, 91, 95},
            {63, 69, 74, 78, 82, 89, 94, 98},
            {65, 72, 76, 81, 85, 92, 96, 101},
            {66, 74, 78, 83, 88, 94, 99, 104},
            {69, 75, 80, 85, 90, 96, 101, 107},
            {70, 77, 82, 88, 92, 99, 104, 109} };

    static int [][] BB6032wind2st2Op = { {63, 64, 66, 70, 73, 75, 78, 80, 82, 84, 90, 92, 95},
            {67, 68, 70, 74, 76, 79, 82, 84, 87, 89, 95, 97, 99},
            {70, 71, 73, 77, 80, 82, 85, 89, 91, 93, 99, 101, 104},
            {76, 77, 80, 84, 87, 90, 93, 96, 98, 101, 107, 110, 112},
            {80, 81, 83, 88, 91, 93, 97, 99, 103, 106, 111, 114, 117},
            {83, 84, 87, 92, 95, 98, 101, 105, 108, 110, 116, 120, 123},
            {86, 87, 90, 95, 98, 101, 106, 109, 112, 114, 121, 124, 127},
            {91, 92, 95, 99, 103, 106, 110, 113, 116, 120, 126, 129, 132},
            {94, 95, 98, 103, 107, 110, 114, 117, 121, 124, 130, 135, 138},
            {97, 98, 101, 107, 110, 113, 117, 122, 125, 128, 136, 139, 142},
            {102, 103, 108, 113, 116, 121, 125, 128, 132, 136, 143, 146, 150},
            {106, 107, 111, 116, 120, 124, 128, 132, 136, 140, 147, 151, 155},
            {109, 110, 114, 120, 124, 128, 132, 137, 140, 144, 152, 156, 159} };

    static int [][] BB6032wind3st2Op = { {82, 84, 88, 90, 91, 93, 96, 98, 100, 103, 105, 107, 112, 114, 116},
            {86, 88, 92, 94, 96, 98, 101, 104, 106, 108, 110, 112, 117, 120, 122},
            {90, 93, 96, 98, 101, 104, 107, 109, 111, 113, 116, 119, 124, 126, 128},
            {98, 101, 105, 107, 110, 112, 115, 117, 121, 123, 125, 128, 133, 136, 139},
            {102, 106, 109, 112, 114, 117, 121, 123, 126, 128, 131, 133, 140, 142, 145},
            {108, 111, 114, 117, 121, 123, 127, 129, 132, 135, 138, 141, 146, 150, 152},
            {112, 115, 120, 122, 125, 128, 131, 135, 138, 141, 143, 146, 153, 156, 158},
            {118, 121, 125, 128, 130, 133, 138, 141, 144, 147, 150, 153, 159, 162, 166},
            {122, 125, 129, 132, 136, 139, 143, 146, 150, 153, 156, 159, 166, 169, 172},
            {126, 130, 133, 138, 141, 144, 148, 152, 155, 158, 161, 164, 172, 175, 178},
            {134, 137, 142, 145, 148, 152, 156, 160, 163, 167, 170, 174, 180, 184, 188},
            {138, 142, 146, 150, 154, 157, 161, 166, 169, 172, 176, 179, 187, 190, 194},
            {143, 146, 151, 155, 158, 162, 167, 171, 174, 178, 182, 186, 192, 197, 201},
            {147, 151, 156, 159, 163, 168, 172, 176, 179, 184, 188, 191, 199, 203, 207},
            {153, 156, 160, 164, 169, 173, 177, 182, 186, 190, 194, 198, 205, 209, 214},
            {157, 161, 166, 170, 174, 178, 183, 187, 191, 195, 200, 204, 211, 216, 220} };

    static int [][] BB6032wind2stNo = { {17, 18, 19, 21, 22, 23, 25, 26, 28, 29, 30, 31, 32, 34, 35},
            {18, 20, 21, 22, 25, 26, 27, 29, 30, 31, 33, 34, 35, 37, 38},
            {20, 21, 23, 25, 27, 28, 30, 31, 33, 34, 36, 37, 40, 41, 42},
            {21, 23, 26, 27, 29, 30, 32, 34, 35, 37, 38, 41, 43, 44, 46},
            {23, 26, 27, 29, 31, 32, 34, 36, 38, 40, 42, 44, 46, 47, 49},
            {25, 27, 29, 31, 33, 35, 36, 38, 41, 43, 45, 47, 49, 51, 52},
            {27, 29, 31, 33, 35, 37, 40, 42, 44, 46, 48, 50, 52, 54, 57},
            {28, 30, 32, 35, 37, 40, 42, 44, 46, 48, 51, 53, 56, 58, 60},
            {30, 32, 34, 36, 40, 42, 44, 47, 49, 51, 53, 57, 59, 61, 64},
            {31, 33, 36, 38, 42, 44, 47, 49, 51, 54, 57, 60, 62, 64, 67},
            {32, 35, 38, 41, 44, 46, 49, 51, 54, 57, 60, 63, 65, 68, 70},
            {34, 37, 40, 43, 46, 48, 51, 54, 57, 60, 63, 65, 68, 72, 75},
            {35, 38, 42, 45, 48, 50, 53, 57, 60, 63, 66, 68, 72, 75, 78},
            {37, 41, 44, 47, 50, 53, 57, 60, 62, 65, 68, 72, 75, 78, 81},
            {38, 42, 45, 49, 52, 56, 59, 62, 65, 68, 72, 75, 78, 81, 85},
            {41, 44, 47, 50, 54, 58, 61, 64, 68, 72, 75, 78, 81, 85, 89} };

    static int [][] BB6032wind3stNo = { {45, 47, 48, 50, 52, 53, 56, 57, 59, 61, 62, 64, 66, 67, 69},
            {48, 50, 52, 54, 56, 58, 60, 62, 63, 65, 67, 68, 70, 73, 75},
            {51, 53, 56, 58, 60, 62, 64, 66, 67, 69, 72, 74, 76, 78, 80},
            {56, 58, 60, 62, 64, 66, 68, 70, 73, 75, 77, 79, 81, 83, 85},
            {59, 61, 63, 65, 67, 69, 73, 75, 77, 79, 81, 83, 85, 89, 91},
            {62, 64, 66, 69, 72, 74, 76, 79, 81, 83, 87, 89, 91, 93, 96},
            {65, 67, 70, 73, 76, 78, 80, 83, 85, 89, 91, 93, 96, 98, 101},
            {68, 72, 74, 77, 79, 82, 84, 88, 90, 93, 96, 98, 101, 104, 107},
            {72, 75, 78, 80, 83, 87, 89, 92, 95, 97, 100, 104, 106, 109, 112},
            {75, 78, 81, 84, 88, 90, 93, 96, 99, 103, 105, 108, 111, 114, 117},
            {78, 81, 84, 88, 91, 94, 97, 100, 104, 107, 110, 113, 116, 120, 123},
            {81, 85, 89, 92, 95, 98, 101, 105, 108, 111, 114, 117, 122, 125, 128},
            {85, 89, 92, 95, 99, 103, 106, 109, 112, 116, 120, 123, 126, 129, 133},
            {89, 92, 95, 99, 103, 106, 110, 113, 117, 121, 124, 128, 131, 135, 139},
            {92, 95, 99, 103, 107, 110, 114, 117, 122, 125, 129, 132, 137, 140, 144},
            {95, 99, 103, 107, 110, 114, 119, 122, 126, 130, 133, 138, 141, 145, 150} };
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
        adapterShprosWidth.addAll(addList(R.array.Width_pod_Otl));

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
                //Если выбраны открывающиеся окна, скрываем тип фигуры(только стандартные) и возвращаем ручки
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
                String itemInfo = "Профиль: " + dataProfile.get(positionProfile1) + "/" + dataTypeOfGlass.get(positionTypeOfGlass1) + (positionTypeOfType1 > 0 || balDorFlag ? " " + dataFurnit.get(positionFurnit1) + "\n" : "\n") +
                                  dataType[positionType1] + " " + (positionType1 != 4 ? dataTypeOfType.get(positionTypeOfType1) + "\n" : dataFilling.get(positionFilling1) + "\n") +
                                  "В " + dataHight.get(positionHight1) + "*" + dataWidth.get(positionWidth1) + " Ш" + "\n" +
                                  dataLamination.get(positionLamination1) + "\n" +
                                  (dataGlassList.size() > 0 ? (dataGlassList.size() > 2 ?
                                          (dataGlassList.get(0).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(0) + ";") +
                                          (dataGlassList.get(1).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(1) + ";") +
                                          (dataGlassList.get(2).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(2) + ";") + "\n" :
                                                (dataGlassList.get(0).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(0) + ";") +
                                                (dataGlassList.get(1).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(1) + ";") + "\n") : "\n") +
                                  (positionTypeOfType1 > 0 || balDorFlag ? (dataHandleList.size() > 2 ? dataHandleList.get(0) + "\n" + dataHandleList.get(1) + "\n" + dataHandleList.get(2) + "\n" :
                                          dataHandleList.get(0) + "\n" + dataHandleList.get(1) + "\n"): "\n") +
                                  (positionTypeOfType1 > 1 ? dataShtulp.get(positionShtulp1) : "");

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

            if (positionLamination1 == 0) {
                laminationCoefficient = 1;
            }
            if (positionLamination1 == 1) {
                laminationCoefficient = DopPrices.lamW1st;
            }
            if (positionLamination1 == 2) {
                laminationCoefficient = DopPrices.lamW2st;
            }

    }
    //____________________________________________________________
    public double setRegionPrice(){
        return Math.ceil(((((price + furnitPrice + priceFigure + priceShtulp)* profileCoefficient)*laminationCoefficient) + lam + shpros + priceHandle + priceGlass) * 1.04);
    }

    public double setMinskPrice() {
        return Math.ceil(((((price + furnitPrice + priceFigure + priceShtulp) * profileCoefficient) * laminationCoefficient) + lam + shpros + priceHandle + priceGlass) * 1.02);
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

        //Обычное окно
        if(positionFigure1 == 0) {
            priceFigure = 0;
            return;
        }
        //Арка
        if(positionFigure1 == 1) {
            priceFigure = DopPrices.arka;
            return;
        }
        //Трапеция 2 угла
        if(positionFigure1 == 2) {
            priceFigure = DopPrices.trapecija * 2;
            return;
        }
        //Трапеция 3 угла
        if(positionFigure1 == 3) {
            priceFigure = DopPrices.trapecija * 3;
            return;
        }
        //Трапеция 4 угла
        if(positionFigure1 == 4) {
            priceFigure = DopPrices.trapecija * 4;
        }
    }

    public void setHandlePriceItems(int p1) {
        //Вызывется после нажатия на кнопку +
        //p1 - Тип ручки

        //Ручка [0]
        //Комплект накладок [1]
        //Хваталка балконная [2]


        //Если открываются окна
        if(gluhFlag == false) {

            //Если выбраны ручки
            if(p1 == 0 || p1 == 1 || p1 == 2 || p1 == 3 || p1 == 4 || p1 == 5 || p1 == 6) {
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
                return;
            }
            //Ручка Roto Samba (белая)
            if(p1 == 1) {
                handlePriceItems[0] = DopPrices.ruchkaSambaBel;
                return;
            }
            //Ручка Hoppe (коричневая)
            if(p1 == 2) {
                handlePriceItems[0] = DopPrices.ruchkaHopeKorich;
                return;
            }
            //Ручка Roto Line (белая, латунь, серо-коричневая, бронза, серебро, шампань, титан, темная бронза)
            if(p1 == 3) {
                handlePriceItems[0] = DopPrices.ruchkaRotoLine;
                return;
            }
            //Ручка Roto Swing (белая, серебро, титан мат)
            if(p1 == 4) {
                handlePriceItems[0] = DopPrices.ruchkaRotoSwingV1;
                return;
            }
            //Ручка Roto Swing (черно-коричневая, новое серебро, латунь мат, бронза, темная бронза)
            if(p1 == 5) {
                handlePriceItems[0] = DopPrices.ruchkaRotoSwingV2;
                return;
            }
            //Ручка с ключом (белая, коричневая)
            if(p1 == 6) {
                handlePriceItems[0] = DopPrices.ruchkaSKluchom;
                return;
            }
            //Комплект декоративных накладок (белый, коричневый)
            if(p1 == 7) {
                handlePriceItems[1] = 0;
                return;
            }
            //Комплект декоративных накладок (цветной)
            if(p1 == 8) {
                handlePriceItems[1] = DopPrices.dekorNakladkaCvet;
                return;
            }
        }
        //Если балконная дверь
        if(balDorFlag == true) {
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
                return;
            }
            //Ручка Roto Samba (белая)
            if(p1 == 1) {
                handlePriceItems[0] = DopPrices.ruchkaSambaBel;
                return;
            }
            //Ручка Hoppe (коричневая)
            if(p1 == 2) {
                handlePriceItems[0] = DopPrices.ruchkaHopeKorich;
                return;
            }
            //Ручка Roto Line (белая, латунь, серо-коричневая, бронза, серебро, шампань, титан, темная бронза)
            if(p1 == 3) {
                handlePriceItems[0] = DopPrices.ruchkaRotoLine;
                return;
            }
            //Ручка Roto Swing (белая, серебро, титан мат)
            if(p1 == 4) {
                handlePriceItems[0] = DopPrices.ruchkaRotoSwingV1;
                return;
            }
            //Ручка Roto Swing (черно-коричневая, новое серебро, латунь мат, бронза, темная бронза)
            if(p1 == 5) {
                handlePriceItems[0] = DopPrices.ruchkaRotoSwingV2;
                return;
            }
            //Ручка 2-х сторонняя (белая, коричневая)
            if(p1 == 6) {
                handlePriceItems[0] = DopPrices.ruchka2storon;
                return;
            }
            //Ручка с ключом (белая, коричневая)
            if(p1 == 7) {
                handlePriceItems[0] = DopPrices.ruchkaSKluchom;
                return;
            }
            //Хваталка балконная (белая, коричневая)
            if(p1 == 8) {
                handlePriceItems[2] = 0;
                return;
            }
            //Хваталка балконная (антрацит, золотой дуб)
            if(p1 == 9) {
                handlePriceItems[2] = DopPrices.hvatalkaCvet;
                return;
            }
            //Комплект декоративных накладок (белый, коричневый)
            if(p1 == 10) {
                handlePriceItems[1] = 0;
                return;
            }
            //Комплект декоративных накладок (цветной)
            if(p1 == 11) {
                handlePriceItems[1] = DopPrices.dekorNakladkaCvet;
                return;
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
            return;
        }
        //Белые шпросы 18 мм
        if (positionShpros1 == 1) {
            shpros = (Double.parseDouble(dataShprosWidth.get(positionShprosWidth1)) / 1000) * DopPrices.shprosBel18mm;
            return;
        }
        //Золотые шпросы 9мм
        if (positionShpros1 == 2) {
            shpros = (Double.parseDouble(dataShprosWidth.get(positionShprosWidth1)) / 1000) * DopPrices.shprosZol8mm;
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
