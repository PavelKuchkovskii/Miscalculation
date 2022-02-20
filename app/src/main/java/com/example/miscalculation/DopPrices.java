package com.example.miscalculation;

import java.io.Serializable;

public class DopPrices implements Serializable{
  //Версия от какого числа(version)
  public String version;

  //Стандартный курс(course)
  public double course;

  //Стандартная доставка(delivery)
  public int delivery;
  //'----------------------------ЛИСТ 1 (ДОПЫ)---------------------------------------------------------
  //'--------------------------Соединители на Brusbox 60:------------------------------------------
  //Балконный соединитель 3мм на 60 профиль(balSoed3mmNa60ProfileBB)
  public double balSoed3mmNa60ProfileBB;

  //Профиль расширительный на 60 профиль 20мм(profRashNa60Profile20mmBB)
  public double profRashNa60Profile20mmBB;

  //Профиль расширительный на 60 профиль 40мм  с армированием(profRashNa60Profile40mmBB)
  public double profRashNa60Profile40mmBB;

  //Профиль расширительный на 60 профиль 65мм с армированием(profRashNa60Profile65mmBB)
  public double profRashNa60Profile65mmBB;

  //Соединитель-молоток 18 мм на 60 профиль с армированием(soedMolotokNA60ProfileBB)
  public double soedMolotokNA60ProfileBB;

  //Соединитель угловой 90° на 60 профиль с армированием(soed90na60ProfileBB)
  public double soed90na60ProfileBB;

  //Соединитель труба с адаптерами 60 мм с армированием(soedTruba60mmBB)
  public double soedTruba60mmBB;

  //'--------------------------Соединители на Brusbox 70:------------------------------------------
  //Балконный соединитель 3мм на 70 профиль(balSoed3mmNa70ProfileBB)
  public double balSoed3mmNa70ProfileBB;

  //Профиль расширительный на 70 профиль 40мм с армированием(profRashNa70Profile40mmBB)
  public double profRashNa70Profile40mmBB;

  //Профиль расширительный на 70 профиль 65мм с армированием(profRashNa70Profile65mmBB)
  public double profRashNa70Profile65mmBB;

  //Соединитель-молоток 18 мм на 70 профиль(soedMolotokNA70ProfileBB)
  public double soedMolotokNA70ProfileBB;

  //Соединитель угловой 90° на 70 профиль с армированием(soed90na70ProfileBB)
  public double soed90na70ProfileBB;

  //Соединитель труба с адаптерами 70 мм с армированием(soedTruba70mmBB)
  public double soedTruba70mmBB;

  //'-----------------------------Соединители на Salamander STL:-----------------------------------

  //Балконный соединитель(balSoedNaSal)
  public double balSoedNaSal;

  //Расширитель 40мм(profRashNaSal40mm)
  public double profRashNaSal40mm;

  //Расширитель 60мм  с армированием(profRashNaSal60mm)
  public double profRashNaSal60mm;

  //Соединитель угловой 90°(soed90naSal)
  public double soed90naSal;

  //Соединитель труба(soedTrubaNaSal)
  public double soedTrubaNaSal;


  //'----------------------------------------------------------------------------------------------

  //Арка - цена прямоугольного окна(arka)
  public double arka;

  //Трапеция - цена прямоугольного окна + за каждый угол(trapecija)
  public double trapecija;

  //Ламинация сендвича(lamSend)
  public double lamSend;

  //'--------------------------------------ЛАМИНАЦИЯ-----------------------------------------------

  //'------------------------------------ОКОН------------------------------------
  //Ламинация односторонняя BRUSBOX 60(lamWBB60_1st)
  public double lamWBB60_1st;
  //Ламинация двухсторонняя BRUSBOX 60(lamWBB60_2st)
  public double lamWBB60_2st;

  //Ламинация односторонняя BRUSBOX 70(lamWBB70_1st)
  public double lamWBB70_1st;
  //Ламинация двухсторонняя BRUSBOX 70(lamWBB70_2st)
  public double lamWBB70_2st;

  //Ламинация односторонняя REHAU 60\70, SALAMANDER(lamWRS_1st)
  public double lamWRS_1st;
  //Ламинация двухсторонняя REHAU 60\70, SALAMANDER(lamWRS_2st)
  public double lamWRS_2st;

  //'------------------------------------ДВЕРЕЙ------------------------------------

  //Ламинация односторонняя - Дверной профиль(lamD1stD)
  public double lamD1stD;
  //Ламинация односторонняя - Оконный профиль(lamD1stW)
  public double lamD1stW;

  //Ламинация двухсторонняя - Дверной профиль(lamD2stD)
  public double lamD2stD;
  //Ламинация двухсторонняя - Оконный профиль(lamD2stW)
  public double lamD2stW;
  //'----------------------------------------------------------------------------------------------

  //Коричневый Алюминий(korichAlumin)
  public double korichAlumin;

  //'----------------------------------------СТЕКЛА------------------------------------------------

  //Мультифункциональное стекло LifeGlassClear(multik)
  public double multik;

  //Бронза(bronza)
  public double bronza;

  //Матовое стекло(mat)
  public double mat;

  //Тонировка(tonirovka)
  public double tonirovka;

  //'----------------------------------------------------------------------------------------------

  //Шпросы белые/коричневые 26мм(shprosBelKor26mm)
  public double shprosBelKor26mm;

  //Шпросы белые/коричневые 18мм(shprosBelKor18mm)
  public double shprosBelKor18mm;

  //Шпросы белые/золотые 8мм(shprosBelZol8mm)
  public double shprosBelZol8mm;

//'----------------------------ЛИСТ 2 (ФУРНИТУРА ОКОННАЯ)--------------------------------------------

  //'---------ЦЕНЫ УКАЗЫВАЕТСЯ В ВВИДЕ РАЗНИЦЫ ОТ СТАНДАРТНОЙ РУЧКИ

  //Ручка оконная Roto Samba белая(ruchkaSambaBel)
  public double ruchkaSambaBel;

  //Ручка оконная Hoppe коричневая(ruchkaHopeKorich)
  public double ruchkaHopeKorich;

  //Ручка оконная Roto Line белая, латунь, серо-коричневая, серебро, шампань, титан, темная бронза, бронза(ruchkaRotoLine)
  public double ruchkaRotoLine;

  //Ручка оконная Roto Swing белая, серебро, титан мат(ruchkaRotoSwingV1)
  public double ruchkaRotoSwingV1;

  //Ручка оконная Roto Swing черно-коричневая, новое серебро, латунь матовая, бронза, темная бронза(ruchkaRotoSwingV2)
  public double ruchkaRotoSwingV2;

  //Ручка 2-хсторонняя белая, коричневая(ruchka2storon)
  public double ruchka2storon;

  //Ручка с ключом белая, коричневая(ruchkaSKluchom)
  public double ruchkaSKluchom;

  //Хваталка балконная антрацит, золотой дуб(hvatalkaCvet)
  public double hvatalkaCvet;

  //Комплект фурнитуры на Roto (стандартное окно)(rotoW)
  public double rotoW;

  //Комплект фурнитуры на Roto (балконная дверь)(rotoBD)
  public double rotoBD;

  //Комлект декоративных накладок цветной(dekorNakladkaCvet)
  public double dekorNakladkaCvet;

//'----------------------------ЛИСТ 3 (ДВЕРНАЯ ФУРНИТУРА)--------------------------------------------

  //'----------ЦЕНЫ УКАЗЫВАЕТСЯ ФАКТИЧЕСКИЕ

  //Петля дверная 90 стандартная (белая, коричневая)(petliDverStndtr)
  public double petliDverStndtr;

  //Петля дверная Roto 120 кг (белая, коричневая)(petliRoto120BelKorich)
  public double petliRoto120BelKorich;

  //Петля дверная Roto 120 кг (антрацит)(petliRoto120Antracit)
  public double petliRoto120Antracit;

  //Петля дверная Roto 120 кг (серебро)(petliRoto120Serebro)
  public double petliRoto120Serebro;

  //Петля дверная Roto 120 кг (бронза)(petliRoto120Bronza)
  public double petliRoto120Bronza;

  //Петля дверная Roto 80 кг (белая, коричневая)(petliRoto80BelKorich)
  public double petliRoto80BelKorich;

  //Петля дверная Jocker 120 кг (белая, коричневая)(petliJoker120BelKorich)
  public double petliJoker120BelKorich;

  //Петля дверная Jocker 120 кг (антрацит, серебро, бронза, титан, черный)(petliJoker120Cvet)
  public double petliJoker120Cvet;

  //Петля дверная Jocker 80 кг (белая, коричневая)(petliJoker80BelKorich)
  public double petliJoker80BelKorich;

  //Петля дверная Jocker 80 кг (антрацит, серебро, бронза, титан, черный)(petliJoker80Cvet)
  public double petliJoker80Cvet;

  //'------------------Гарнитуры указываются разницей от стандартных ручек

  //Ручка дверная прямая (белый, коричневый) (СКОБА)(ruchkaSkobaBelKorich)
  public double ruchkaSkobaBelKorich;

  //Ручка дверная прямая (антрацит, серебро, черный) (СКОБА)(ruchkaSkobaCvet)
  public double ruchkaSkobaCvet;

  //Ручка дверная прямая (нержавейка) (СКОБА)(ruchkaSkobaNerzh)
  public double ruchkaSkobaNerzh;

  //Нажимной гарнитур стандартный (белый/коричневый) собирается из двух(garnitStndr2)
  public double garnitStndr2;

  //Нажимной гарнитур Medos VIKTORY на широкой планке (белый, коричневый)(garnitMedosVictory)
  public double garnitMedosVictory;

  //Нажимной гарнитур Medos VIKTORY на широкой планке (белый/коричневый) собирается из 2-х(garnitMedosVictory2)
  public double garnitMedosVictory2;

  //Нажимной гарнитур Medos VIKTORY на широкой планке (антрацит, бронза, черный, серебро, титан)(garnitMedosVictoryCvet)
  public double garnitMedosVictoryCvet;

  //Нажимной гарнитур Medos VIKTORY на широкой планке (белый/(антрацит, бронза, черный, серебро, титан)) из 2-х(garnitMedosVictoryCvet2)
  public double garnitMedosVictoryCvet2;

  //Замок многозапорный защелка(mnogozapornik)
  public double mnogozapornik;

  //Замок многозапорный Roto ролик(mnogozapornikRolik)
  public double mnogozapornikRolik;

  //Цилиндр ключ-барашка(barashka)
  public double barashka;

  //'----------------------------ЛИСТ 4 (ПРОЧЕЕ)--------------------------------------------
  //м/сетка нар белая(msBelNar)
  public double msBelNar;

  //м/сетка нар кор(msKorichNar)
  public double msKorichNar;

  //м/сетка вн белая(msBelVnut)
  public double msBelVnut;

  //м/сетка вн кор(msKorichVnut)
  public double msKorichVnut;

  //м/сетка на двери бел(msBelDver)
  public double msBelDver;

  //м/сетка на двери кор(msKorichDver)
  public double msKorichDver;

  //м/сетка на алюмин(msAlumin)
  public double msAlumin;

  //'--------------------------------ПОДОКОННИКИ(ЦЕНА ЗА КВ.М)-------------------------------------
  //Подоконник Обычный(PODSTNDRT)
  public double PODSTNDRT;

  //Подоконник Ламинированый(PODLAM)
  public double PODLAM;

  //Подоконник Crystallit(PODCRYSTALLIT)
  public double PODCRYSTALLIT;

  //Подоконник Danke KOFMORT(PODDANKEKOMFORT)
  public double PODDANKEKOMFORT;

  //Подоконник Danke STANDART(PODDANKESTANDART)
  public double PODDANKESTANDART;

  //Подоконник Danke PREMIUM(PODDANKEPREMIUM)
  public double PODDANKEPREMIUM;

  //Подоконник ESTERA(PODESTERA)
  public double PODESTERA;

  //ЗАГЛУШКА ДЛЯ ОБЫЧНОГО(ZAGLSTNDRT)
  public double ZAGLSTNDRT;

  //ЗАГЛУШКА ДЛЯ ОБЫЧНОГО КРАШЕННАЯ(ZAGLSTNDRTCOLOR)
  public double ZAGLSTNDRTCOLOR;

  //ЗАГЛУШКА ДЛЯ CRYSTALLIT(ZAGLCRYSTALLIT)
  public double ZAGLCRYSTALLIT;

  //ЗАГЛУШКА ДЛЯ DANKE(ZAGLDANKE)
  public double ZAGLDANKE;

  //ЗАГЛУШКА ДЛЯ ESTERA(ZAGLESTERA)
  public double ZAGLESTERA;

  //'----------------------------------------------------------------------------------------------

  //Деревянный брус 50*50(derBrus50)
  public double derBrus50;

  //Деревянный брус 100*100(derBrus100)
  public double derBrus100;

  //Нащельник ПВХ(nashPvh)
  public double nashPvh;

  //Двутавр на алюминьку(dvutavr)
  public double dvutavr;

  //Соединитель труба на алюминий(soedTrubaNaAlumin)
  public double soedTrubaNaAlumin;

  //Соединитель 90 градусов на Алюминий(soed90NaAlumin)
  public double soed90NaAlumin;

  //Профиль расширительный на Алюминий 60 мм + двутавр(profRashNaAlumin60mm)
  public double profRashNaAlumin60mm;

  //Профиль расширительный на Алюминий 40 мм + двутавр(profRashNaAlumin40mm)
  public double profRashNaAlumin40mm;

  //Штульп(shtulp)
  public int shtulp;

  //Порог ПВХ(porogPvh)
  public int porogPvh;


//'--------------------------------КОЭФИЦЕНТЫ ПРОФИЛЕЙ-----------------------------------------------

  //'---------------------------ОКОННЫЕ КОЭФИЦЕНТЫ-------------------------------------------------
  //Brusbox 60/24 окно(BB6024W)
  public double BB6024W;

  //Brusbox 60/32 окно(BB6032W)
  public double BB6032W;

  //Brusbox 70/24 окно(BB7024W)
  public double BB7024W;

  //Brusbox 70/32 окно(BB7032W)
  public double BB7032W;

  //Brusbox 70/40 окно(BB7040W)
  public double BB7040W;

  //Brusbox 70/24 А-Класс окно(BBA7024W)
  public double BBA7024W;

  //Brusbox 70/32 А-Класс окно(BBA7032W)
  public double BBA7032W;

  //Brusbox 70/40 А-Класс окно(BBA7040W)
  public double BBA7040W;

  //Rehau 60/24 окно(REHAU6024W)
  public double REHAU6024W;

  //Rehau 60/32 окно(REHAU6032W)
  public double REHAU6032W;

  //Rehau 70/24 окно(REHAU7024W)
  public double REHAU7024W;

  //Rehau 70/32 окно(REHAU7032W)
  public double REHAU7032W;

  //Rehau 70/40 окно(REHAU7040W)
  public double REHAU7040W;

  //Salamander 70/32 окно(SALAMANDER7032W)
  public double SALAMANDER7032W;

  //Salamander 70/40 окно(SALAMANDER7040W)
  public double SALAMANDER7040W;

  //'---------------------------ДВЕРНЫЕ КОЭФИЦЕНТЫ-------------------------------------------------

  // 70/40 Дверной/Оконный(BB7040D)
  public double BB7040D;

  // 70/32 Дверной/Оконный(BB7032D)
  public double BB7032D;

  // 70/24 Дверной/Оконный(BB7024D)
  public double BB7024D;

  // 60/32 Дверной/Оконный(BB6032D)
  public double BB6032D;

  // 60/24 Дверной/Оконный(BB6024D)
  public double BB6024D;


//'-----------------------------------------ИНТЕРЕС--------------------------------------------------

  //'------------------------------ИНЕТРЕС НА ОКНА-------------------------------------------------

  //ИНТЕРЕС НА 1 СТВОРЧАТОЕ ОКНО(INTW1ST)
  public int INTW1ST;

  //ИНТЕРЕС НА 1 СТВОРЧАТОЕ ОКНО шириной мень либо равное 600 и высотой меньшей либо равной 800(INTW1STV2)
  public int INTW1STV2;

  //ИНТЕРЕС НА 2 СТВОРЧАТОЕ ОКНО(INTW2ST)
  public int INTW2ST;

  //ИНТЕРЕС НА 3 СТВОРЧАТОЕ ОКНО(INTW3ST)
  public int INTW3ST;

  //ИНТЕРЕС НА 4 СТВОРЧАТОЕ ОКНО(РАМА) ШИРИНА < 3300 (65)(INTW4ST)
  public int INTW4ST;

  //ИНТЕРЕС НА 4 СТВОРЧАТОЕ ОКНО(РАМА) ВЫОСТОЙ БОЛЬШЕ 1600 (70)(INTW4STV2)
  public int INTW4STV2;

  //ИНТЕРЕС НА 4 СТВОРЧАТОЕ ОКНО(РАМА) ШИРИНА 3300 - 4000 (80)(INTW4STV3)
  public int INTW4STV3;

  //ИНТЕРЕС НА 4 СТВОРЧАТОЕ ОКНО(РАМА) ШИРИНА 4000-5000 (100)(INTW4STV4)
  public int INTW4STV4;

  //ИНТЕРЕС НА 4 СТВОРЧАТОЕ ОКНО(РАМА) ШИРИНА > 5000 (130)(INTW4STV5)
  public int INTW4STV5;

  //ИНТЕРЕС НА БАЛКОННУЮ ДВЕРЬ(INTBALDOR)
  public int INTBALDOR;

  //ИНТЕРЕС НА БАЛКОННУЮ ГРУППУ C ОДНИМ ОКНОМ(INTBALBLOCK)
  public int INTBALBLOCK;

  //ИНТЕРЕС НА БАЛКОННУЮ ГРУППУ ЧЕБУРАШКА(INTBALBLOCK2)
  public int INTBALBLOCK2;

  //ИНТЕРЕС НА 1 СТВОРКУ В ПОЛУКРУГЛОЙ РАМЕ(INTPOLRAM)
  public int INTPOLRAM;

  //'------------------------------ИНЕТРЕС НА ДВЕРИ------------------------------------------------

  //ИНТЕРЕС НА 1 СТВОРЧАТУЮ ДВЕРЬ(INTDOOR1ST)
  public int INTDOOR1ST;

  //ИНТЕРЕС НА ШТУЛЬПОВУЮ ДВЕРЬ(INTDOOR2ST)
  public int INTDOOR2ST;



//'-----------------------------------------РАБОТЫ--------------------------------------------------

  //МОНТАЖ НАЩЕЛЬНИКОВ С 1 СТОРОНЫ(WORKNASH)
  public int WORKNASH;

  //ЦЕНА НАКИДКИ ЕСЛИ РАЗМЕРЫ ЗА РАМКАМИ В РЕГИОНЕ(WORKMORE_R)
  public int WORKMORE_R;
  //ЦЕНА НАКИДКИ ЕСЛИ ВЫСОТА ВЫШЕ 1610 В МИНСКЕ(WORKMORE_M)
  public int WORKMORE_M;

  //'------------------------------МОНТАЖ ОКОН РЕГИОН-------------------------------------------------

  //МОНТАЖ НА 1 СТВОРЧАТОЕ ОКНО(WORK1ST_R)
  public int WORK1ST_R;

  //МОНТАЖ НА 2 СТВОРЧАТОЕ ОКНО(WORK2ST_R)
  public int WORK2ST_R;

  //МОНТАЖ НА 3 СТВОРЧАТОЕ ОКНО(WORK3ST_R)
  public int WORK3ST_R;

  //МОНТАЖ НА 4 СТВОРЧАТОЕ ОКНО(РАМА) < 3300(WORK4ST1_R)
  public int WORK4ST1_R;
  //МОНТАЖ НА 4 СТВОРЧАТОЕ ОКНО(РАМА) - 3300 - 4300(WORK4ST2_R)
  public int WORK4ST2_R;
  //МОНТАЖ НА 4 СТВОРЧАТОЕ ОКНО(РАМА) > 4300(WORK4ST3_R)
  public int WORK4ST3_R;
  //МОНТАЖ НА 4 СТВОРЧАТОЕ ОКНО(РАМА) > 5000(WORK4ST4_R)
  public int WORK4ST4_R;
  //МОНТАЖ НА 4 СТВОРЧАТОЕ ЗА ПОВОРОТ(WORK4ST5_R)
  public int WORK4ST5_R;

  //МОНТАЖ НА БАЛКОННУЮ ГРУППУ 1 ОКНО(WORKBALBLOCK1_R)
  public int WORKBALBLOCK1_R;

  //МОНТАЖ НА БАЛКОННУЮ ГРУППУ ЧЕБУРАШКА(WORKBALBLOCK2_R)
  public int WORKBALBLOCK2_R;

  //МОНТАЖ НА ПОЛУКРУГЛУЮ РАМУ ИЗ 4 ЧАСТЕЙ(WORKPOLRAM1_R)
  public int WORKPOLRAM1_R;

  //МОНТАЖ НА ПОЛУКРУГЛУЮ РАМУ ИЗ 5 ЧАСТЕЙ(WORKPOLRAM2_R)
  public int WORKPOLRAM2_R;

  //'------------------------------МОНТАЖ ОКОН МИНСК-------------------------------------------------

  //МОНТАЖ НА 1 СТВОРЧАТОЕ ОКНО(WORK1ST_M)
  public int WORK1ST_M;

  //МОНТАЖ НА 2 СТВОРЧАТОЕ ОКНО(WORK2ST_M)
  public int WORK2ST_M;

  //МОНТАЖ НА 3 СТВОРЧАТОЕ ОКНО(WORK3ST_M)
  public int WORK3ST_M;

  //МОНТАЖ НА 4 СТВОРЧАТОЕ ОКНО(РАМА) < 3300(WORK4ST1_M)
  public int WORK4ST1_M;
  //МОНТАЖ НА 4 СТВОРЧАТОЕ ОКНО(РАМА) - 3300 - 4300(WORK4ST2_M)
  public int WORK4ST2_M;
  //МОНТАЖ НА 4 СТВОРЧАТОЕ ОКНО(РАМА) > 4300(WORK4ST3_M)
  public int WORK4ST3_M;
  //МОНТАЖ НА 4 СТВОРЧАТОЕ ОКНО(РАМА) > 5000(WORK4ST4_M)
  public int WORK4ST4_M;
  //МОНТАЖ НА 4 СТВОРЧАТОЕ ЗА ПОВОРОТ(WORK4ST5_M)
  public int WORK4ST5_M;

  //МОНТАЖ НА БАЛКОННУЮ ГРУППУ 1 ОКНО(WORKBALBLOCK1_M)
  public int WORKBALBLOCK1_M;

  //МОНТАЖ НА БАЛКОННУЮ ГРУППУ ЧЕБУРАШКА(WORKBALBLOCK2_M)
  public int WORKBALBLOCK2_M;

  //МОНТАЖ НА ПОЛУКРУГЛУЮ РАМУ ИЗ 4 ЧАСТЕЙ(WORKPOLRAM1_M)
  public int WORKPOLRAM1_M;

  //МОНТАЖ НА ПОЛУКРУГЛУЮ РАМУ ИЗ 5 ЧАСТЕЙ(WORKPOLRAM2_M)
  public int WORKPOLRAM2_M;

  //'------------------------------МОНТАЖ ДВЕРЕЙ РЕГИОН------------------------------------------------

  //МОНТАЖ НА 1 СТВОРЧАТУЮ ДВЕРЬ(WORKDOOR1ST_R)
  public int WORKDOOR1ST_R;

  //МОНТАЖ НА 1 СТВОРЧАТУЮ ДВЕРЬ С ФРАМУГОЙ(WORKDOOR1STF_R)
  public int WORKDOOR1STF_R;

  //МОНТАЖ НА ШТУЛЬПОВУЮ ДВЕРЬ(WORKDOOR2ST_R)
  public int WORKDOOR2ST_R;

  //МОНТАЖ НА ШТУЛЬПОВУЮ ДВЕРЬ С ФРАМУГОЙ(WORKDOOR2STF_R)
  public int WORKDOOR2STF_R;

  //'------------------------------МОНТАЖ ДВЕРЕЙ МИНСК------------------------------------------------

  //МОНТАЖ НА 1 СТВОРЧАТУЮ ДВЕРЬ(WORKDOOR1ST_M)
  public int WORKDOOR1ST_M;

  //МОНТАЖ НА 1 СТВОРЧАТУЮ ДВЕРЬ С ФРАМУГОЙ(WORKDOOR1STF_M)
  public int WORKDOOR1STF_M;

  //МОНТАЖ НА ШТУЛЬПОВУЮ ДВЕРЬ(WORKDOOR2ST_M)
  public int WORKDOOR2ST_M;

  //МОНТАЖ НА ШТУЛЬПОВУЮ ДВЕРЬ С ФРАМУГОЙ(WORKDOOR2STF_M)
  public int WORKDOOR2STF_M;

  //'------------------------------МОНТАЖ ОТКОСОВ РЕГИОН-------------------------------------------------

  //МОНТАЖ ОТКОСОВ НА 1 СТВОРЧАТОЕ ОКНО ДО 250 мм(SLP1ST1_R)
  public int SLP1ST1_R;
  //МОНТАЖ ОТКОСОВ НА 1 СТВОРЧАТОЕ ОКНО СВЫШЕ 250 мм(SLP1ST2_R)
  public int SLP1ST2_R;
  //МОНТАЖ ОТКОСОВ НА 1 СТВОРЧАТОЕ ОКНО СВЫШЕ 450 мм(SLP1ST3_R)
  public int SLP1ST3_R;

  //МОНТАЖ ОТКОСОВ НА 2 СТВОРЧАТОЕ ОКНО ДО 250 мм(SLP2ST1_R)
  public int SLP2ST1_R;
  //МОНТАЖ ОТКОСОВ НА 2 СТВОРЧАТОЕ ОКНО СВЫШЕ 250 мм(SLP2ST2_R)
  public int SLP2ST2_R;
  //МОНТАЖ ОТКОСОВ НА 2 СТВОРЧАТОЕ ОКНО СВЫШЕ 450 мм(SLP2ST3_R)
  public int SLP2ST3_R;

  //МОНТАЖ ОТКОСОВ НА 3 СТВОРЧАТОЕ ОКНО ДО 250 мм(SLP3ST1_R)
  public int SLP3ST1_R;
  //МОНТАЖ ОТКОСОВ НА 3 СТВОРЧАТОЕ ОКНО СВЫШЕ 250 мм(SLP3ST2_R)
  public int SLP3ST2_R;
  //МОНТАЖ ОТКОСОВ НА 3 СТВОРЧАТОЕ ОКНО СВЫШЕ 450 мм(SLP3ST3_R)
  public int SLP3ST3_R;

  //МОНТАЖ ОТКОСОВ НА БАЛКОННУЮ ГРУППУ 1 ОКНО ДО 250 мм(SLPBALBLOCK1_1_R)
  public int SLPBALBLOCK1_1_R;
  //МОНТАЖ ОТКОСОВ НА БАЛКОННУЮ ГРУППУ 1 ОКНО СВЫШЕ 250 мм(SLPBALBLOCK1_2_R)
  public int SLPBALBLOCK1_2_R;
  //МОНТАЖ ОТКОСОВ НА БАЛКОННУЮ ГРУППУ 1 ОКНО СВЫШЕ 450 мм(SLPBALBLOCK1_3_R)
  public int SLPBALBLOCK1_3_R;

  //МОНТАЖ ОТКОСОВ НА БАЛКОННУЮ ГРУППУ ЧЕБУРАШКА ДО 250 мм(SLPBALBLOCK2_1_R)
  public int SLPBALBLOCK2_1_R;
  //МОНТАЖ ОТКОСОВ НА БАЛКОННУЮ ГРУППУ ЧЕБУРАШКА СВЫШЕ 250 мм(SLPBALBLOCK2_2_R)
  public int SLPBALBLOCK2_2_R;
  //МОНТАЖ ОТКОСОВ НА БАЛКОННУЮ ГРУППУ ЧЕБУРАШКА СВЫШЕ 450 мм(SLPBALBLOCK2_3_R)
  public int SLPBALBLOCK2_3_R;

  //'------------------------------МОНТАЖ ОТКОСОВ МИНСК-------------------------------------------------

  //МОНТАЖ ОТКОСОВ НА 1 СТВОРЧАТОЕ ОКНО ДО 250 мм(SLP1ST1_M)
  public int SLP1ST1_M;
  //МОНТАЖ ОТКОСОВ НА 1 СТВОРЧАТОЕ ОКНО СВЫШЕ 250 мм(SLP1ST2_M)
  public int SLP1ST2_M;
  //МОНТАЖ ОТКОСОВ НА 1 СТВОРЧАТОЕ ОКНО СВЫШЕ 450 мм(SLP1ST3_M)
  public int SLP1ST3_M;

  //МОНТАЖ ОТКОСОВ НА 2 СТВОРЧАТОЕ ОКНО ДО 250 мм(SLP2ST1_M)
  public int SLP2ST1_M;
  //МОНТАЖ ОТКОСОВ НА 2 СТВОРЧАТОЕ ОКНО СВЫШЕ 250 мм(SLP2ST2_M)
  public int SLP2ST2_M;
  //МОНТАЖ ОТКОСОВ НА 2 СТВОРЧАТОЕ ОКНО СВЫШЕ 450 мм(SLP2ST3_M)
  public int SLP2ST3_M;

  //МОНТАЖ ОТКОСОВ НА 3 СТВОРЧАТОЕ ОКНО ДО 250 мм(SLP3ST1_M)
  public int SLP3ST1_M;
  //МОНТАЖ ОТКОСОВ НА 3 СТВОРЧАТОЕ ОКНО СВЫШЕ 250 мм(SLP3ST2_M)
  public int SLP3ST2_M;
  //МОНТАЖ ОТКОСОВ НА 3 СТВОРЧАТОЕ ОКНО СВЫШЕ 450 мм(SLP3ST3_M)
  public int SLP3ST3_M;

  //МОНТАЖ ОТКОСОВ НА БАЛКОННУЮ ГРУППУ 1 ОКНО ДО 250 мм(SLPBALBLOCK1_1_M)
  public int SLPBALBLOCK1_1_M;
  //МОНТАЖ ОТКОСОВ НА БАЛКОННУЮ ГРУППУ 1 ОКНО СВЫШЕ 250 мм(SLPBALBLOCK1_2_M)
  public int SLPBALBLOCK1_2_M;
  //МОНТАЖ ОТКОСОВ НА БАЛКОННУЮ ГРУППУ 1 ОКНО СВЫШЕ 450 мм(SLPBALBLOCK1_3_M)
  public int SLPBALBLOCK1_3_M;

  //МОНТАЖ ОТКОСОВ НА БАЛКОННУЮ ГРУППУ ЧЕБУРАШКА ДО 250 мм(SLPBALBLOCK2_1_M)
  public int SLPBALBLOCK2_1_M;
  //МОНТАЖ ОТКОСОВ НА БАЛКОННУЮ ГРУППУ ЧЕБУРАШКА СВЫШЕ 250 мм(SLPBALBLOCK2_2_M)
  public int SLPBALBLOCK2_2_M;
  //МОНТАЖ ОТКОСОВ НА БАЛКОННУЮ ГРУППУ ЧЕБУРАШКА СВЫШЕ 450 мм(SLPBALBLOCK2_3_M)
  public int SLPBALBLOCK2_3_M;

  //'------------------------------МОНТАЖ ОТКОСОВ НА ДВЕРИ РЕГИОН----------------------------------

  //МОНТАЖ ОТСКОСОВ НА 1 СТВОРЧАТУЮ ДВЕРЬ ДО 250 мм(SLPDOOR1ST1_R)
  public int SLPDOOR1ST1_R;
  //МОНТАЖ ОТСКОСОВ НА 1 СТВОРЧАТУЮ ДВЕРЬ СВЫШЕ 250 мм(SLPDOOR1ST2_R)
  public int SLPDOOR1ST2_R;
  //МОНТАЖ ОТСКОСОВ НА 1 СТВОРЧАТУЮ ДВЕРЬ СВЫШЕ 450 мм(SLPDOOR1ST3_R)
  public int SLPDOOR1ST3_R;

  //МОНТАЖ ОТСКОСОВ НА 1 СТВОРЧАТУЮ ДВЕРЬ С ФРАМУГОЙ ДО 250 мм(SLPDOOR1STF1_R)
  public int SLPDOOR1STF1_R;
  //МОНТАЖ ОТСКОСОВ НА 1 СТВОРЧАТУЮ ДВЕРЬ С ФРАМУГОЙ СВЫШЕ 250 мм(SLPDOOR1STF2_R)
  public int SLPDOOR1STF2_R;
  //МОНТАЖ ОТСКОСОВ НА 1 СТВОРЧАТУЮ ДВЕРЬ С ФРАМУГОЙ СВЫШЕ 450 мм(SLPDOOR1STF3_R)
  public int SLPDOOR1STF3_R;

  //МОНТАЖ ОТСКОСОВ НА ШТУЛЬПОВУЮ ДВЕРЬ ДО 250 мм(SLPDOOR2ST1_R)
  public int SLPDOOR2ST1_R;
  //МОНТАЖ ОТСКОСОВ НА ШТУЛЬПОВУЮ ДВЕРЬ СВЫШЕ 250 мм(SLPDOOR2ST2_R)
  public int SLPDOOR2ST2_R;
  //МОНТАЖ ОТСКОСОВ НА ШТУЛЬПОВУЮ ДВЕРЬ СВЫШЕ 450 мм(SLPDOOR2ST3_R)
  public int SLPDOOR2ST3_R;

  //МОНТАЖ ОТСКОСОВ НА ШТУЛЬПОВУЮ ДВЕРЬ С ФРАМУГОЙ ДО 250 мм(SLPDOOR2STF1_R)
  public int SLPDOOR2STF1_R;
  //МОНТАЖ ОТСКОСОВ НА ШТУЛЬПОВУЮ ДВЕРЬ С ФРАМУГОЙ СВЫШЕ 250 мм(SLPDOOR2STF2_R)
  public int SLPDOOR2STF2_R;
  //МОНТАЖ ОТСКОСОВ НА ШТУЛЬПОВУЮ ДВЕРЬ С ФРАМУГОЙ СВЫШЕ 450 мм(SLPDOOR2STF3_R)
  public int SLPDOOR2STF3_R;

  //'------------------------------МОНТАЖ ОТКОСОВ НА ДВЕРИ МИНСК-----------------------------------

  //МОНТАЖ ОТСКОСОВ НА 1 СТВОРЧАТУЮ ДВЕРЬ ДО 250 мм(SLPDOOR1ST1_M)
  public int SLPDOOR1ST1_M;
  //МОНТАЖ ОТСКОСОВ НА 1 СТВОРЧАТУЮ ДВЕРЬ СВЫШЕ 250 мм(SLPDOOR1ST2_M)
  public int SLPDOOR1ST2_M;
  //МОНТАЖ ОТСКОСОВ НА 1 СТВОРЧАТУЮ ДВЕРЬ СВЫШЕ 450 мм(SLPDOOR1ST3_M)
  public int SLPDOOR1ST3_M;

  //МОНТАЖ ОТСКОСОВ НА 1 СТВОРЧАТУЮ ДВЕРЬ С ФРАМУГОЙ ДО 250 мм(SLPDOOR1STF1_M)
  public int SLPDOOR1STF1_M;
  //МОНТАЖ ОТСКОСОВ НА 1 СТВОРЧАТУЮ ДВЕРЬ С ФРАМУГОЙ СВЫШЕ 250 мм(SLPDOOR1STF2_M)
  public int SLPDOOR1STF2_M;
  //МОНТАЖ ОТСКОСОВ НА 1 СТВОРЧАТУЮ ДВЕРЬ С ФРАМУГОЙ СВЫШЕ 450 мм(SLPDOOR1STF3_M)
  public int SLPDOOR1STF3_M;

  //МОНТАЖ ОТСКОСОВ НА ШТУЛЬПОВУЮ ДВЕРЬ ДО 250 мм(SLPDOOR2ST1_M)
  public int SLPDOOR2ST1_M;
  //МОНТАЖ ОТСКОСОВ НА ШТУЛЬПОВУЮ ДВЕРЬ СВЫШЕ 250 мм(SLPDOOR2ST2_M)
  public int SLPDOOR2ST2_M;
  //МОНТАЖ ОТСКОСОВ НА ШТУЛЬПОВУЮ ДВЕРЬ СВЫШЕ 450 мм(SLPDOOR2ST3_M)
  public int SLPDOOR2ST3_M;

  //МОНТАЖ ОТСКОСОВ НА ШТУЛЬПОВУЮ ДВЕРЬ С ФРАМУГОЙ ДО 250 мм(SLPDOOR2STF1_M)
  public int SLPDOOR2STF1_M;
  //МОНТАЖ ОТСКОСОВ НА ШТУЛЬПОВУЮ ДВЕРЬ С ФРАМУГОЙ СВЫШЕ 250 мм(SLPDOOR2STF2_M)
  public int SLPDOOR2STF2_M;
  //МОНТАЖ ОТСКОСОВ НА ШТУЛЬПОВУЮ ДВЕРЬ С ФРАМУГОЙ СВЫШЕ 450 мм(SLPDOOR2STF3_M)
  public int SLPDOOR2STF3_M;

//'------------------------------------ЛИЗИНГ--------------------------------------------------------
  //'------------------------------ПО МЕСЯЦАМ------------------------------------------------------

  //4 месяца(LIZING4M)
  public double LIZING4M;

  //6 месяцев(LIZING6M)
  public double LIZING6M;

  //12 месяцев(LIZING12M)
  public double LIZING12M;

  //20 месяцев(LIZING20M)
  public double LIZING20M;

  //24 месяцев(LIZING24M)
  public double LIZING24M;
//'------------------------------АЛЬФА-БАНК------------------------------
          //'------------------------------ПО МЕСЯЦАМ-----------------------------------------------
  // 6 месяцев(AMES6)
  public double AMES6;

  //10 месяцев(AMES10)
  public double AMES10;

  //12 месяцев(AMES12)
  public double AMES12;

  //15 месяцев(AMES15)
  public double AMES15;

  //18 месяцев(AMES18)
  public double AMES18;

  //24 месяцев(AMES24)
  public double AMES24;

  //36 месяцев(AMES36)
  public double AMES36;
//'------------------------------ЕЖЕМЕС------------------------------------------------------

  //6 месяцев(AMES_E6)
  public double AMES_E6;

  //10 месяцев(AMES_E10)
  public double AMES_E10;

  //12 месяцев(AMES_E12)
  public double AMES_E12;

  //15 месяцев(AMES_E15)
  public double AMES_E15;

  //18 месяцев(AMES_E18)
  public double AMES_E18;

  //24 месяцев(AMES_E24)
  public double AMES_E24;

  //36 месяцев(AMES_E36)
  public double AMES_E36;
//'------------------------------ДОБРОБЫТ------------------------------
         //'------------------------------ПО МЕСЯЦАМ------------------------------------------------
  //3-6 месяцев(DMES6)
  public double DMES6;

  //7-12 месяцев(DMES12)
  public double DMES12;

  //13-18 месяцев(DMES18)
  public double DMES18;

  //19-24 месяцев(DMES24)
  public double DMES24;

  //25-36 месяцев(DMES36)
  public double DMES36;
//'------------------------------ЕЖЕМЕС------------------------------------------------------
  //3-6 месяцев(DMES_E3)
  public double DMES_E6;

  //7-12 месяцев(DMES_E12)
  public double DMES_E12;

  //13-18 месяцев(DMES_E18)
  public double DMES_E18;

  //19-24 месяцев(DMES_E24)
  public double DMES_E24;

  //25-36 месяцев(DMES_E36)
  public double DMES_E36;
//'------------------------------------МАССИВЫ-------------------------------

  //'------------------------------------ОКНА ПВХ------------------------------------

  //'------------------------------------60/24------------------------------------

  //ПРАЙС НА 1 - СТВОРЧАТОЕ ГЛУХОЕ
  public int [][] BB6024wind1stNo;

  //ПРАЙС НА 1 - СТВОРЧАТОЕ ОТКР
  public int [][] BB6024wind1stOp;

  //ПРАЙС НА 2 - СТВОРЧАТОЕ (1 ОТКР)
  public int [][] BB6024wind2st1Op;

  //ПРАЙС НА 3 - СТВОРЧАТОЕ (1 ОТКР)
  public int [][] BB6024wind3st1Op;

  //ПРАЙС НА 4 - СТВОРЧАТОЕ (2 ОТКР)
  public int [][] BB6024wind4st2Op;

  //ПРАЙС НА БАЛКОННУЮ ДВЕРЬ
  public int [][] BB6024balDor;

  //ПРАЙС НА 2 - СТВОРЧАТОЕ (2 ОТКР)
  public int [][] BB6024wind2st2Op;

  //ПРАЙС НА 3 - СТВОРЧАТОЕ (2 ОТКР)
  public int [][] BB6024wind3st2Op;

  //ПРАЙС НА 2 - СТВОРЧАТОЕ (ГЛУХОЕ)
  public int [][] BB6024wind2stNo;

  //ПРАЙС НА 3 - СТВОРЧАТОЕ (ГЛУХОЕ)
  public int [][] BB6024wind3stNo;

//'------------------------------------60/32------------------------------------

  //ПРАЙС НА 1 - СТВОРЧАТОЕ ГЛУХОЕ
  public int [][] BB6032wind1stNo;

  //ПРАЙС НА 1 - СТВОРЧАТОЕ (1 ОТКР)
  public int [][] BB6032wind1stOp;

  //ПРАЙС НА 2 - СТВОРЧАТОЕ (1 ОТКР)
  public int [][] BB6032wind2st1Op;

  //ПРАЙС НА 3 - СТВОРЧАТОЕ (1 ОТКР)
  public int [][] BB6032wind3st1Op;

  //ПРАЙС НА 4 - СТВОРЧАТОЕ (2 ОТКР)
  public int [][] BB6032wind4st2Op;

  //ПРАЙС НА БАЛКОННУЮ ДВЕРЬ
  public int [][] BB6032balDor;

  //ПРАЙС НА 2 - СТВОРЧАТОЕ (2 ОТКР)
  public int [][] BB6032wind2st2Op;

  //ПРАЙС НА 3 - СТВОРЧАТОЕ (2 ОТКР)
  public int [][] BB6032wind3st2Op;

  //ПРАЙС НА 2 - СТВОРЧАТОЕ (ГЛУХОЕ)
  public int [][] BB6032wind2stNo;

  //ПРАЙС НА 3 - СТВОРЧАТОЕ (ГЛУХОЕ)
  public int [][] BB6032wind3stNo;

  //'------------------------------------АЛЮМИНЬКИ------------------------------------
  //ПРАЙС НА 1 - СТВОРЧАТОЕ ГЛУХОЕ
  public int [][] windAl1stNo;

  //ПРАЙС НА 2 - СТВОРЧАТОЕ (1 ОТКР)
  public int [][] windAl2st1Op;

  //ПРАЙС НА 3 - СТВОРЧАТОЕ (1 ОТКР)
  public int [][] windAl3st1Op;

  //ПРАЙС НА 4 - СТВОРЧАТОЕ (2 ОТКР)
  public int [][] windAl4st2Op;

//'------------------------------------ДВЕРИ ПВХ------------------------------------

  //'------------------60/32----------------------------------------
  public int [][] doorBB6032D1;

  public int [][] doorBB6032D2;

  public int [][] doorBB6032W1;

  public int [][] doorBB6032W2;

//'------------------70/32----------------------------------------

  public int [][] doorBB7032D1;

  public int [][] doorBB7032D2;

  public int [][] doorBB7032W1;

  public int [][] doorBB7032W2;

}
