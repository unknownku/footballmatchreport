/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advdb.footballclub;

import com.advdb.footballclub.domain.DimCompetition;
import com.advdb.footballclub.domain.DimDate;
import com.advdb.footballclub.domain.DimOpponent;
import com.advdb.footballclub.domain.DimPlayer;
import com.advdb.footballclub.domain.DimTactic;
import com.advdb.footballclub.domain.FactMatch;
import com.advdb.footballclub.domain.FactMeasure;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import static java.lang.System.exit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author apichart
 */
public class FootBallClub {

    private static final String[] COMPETITION_NAME_ARR = {"European Cup", "FA Cup", "Premier League", "Champions League"};
    private static final String[] TACTIC_NAME_ARR = {"3-4-1-2", "4-2-3-1", "4-3-3", "4-4-2", "5-3-2", "5-4-1"};
    private static final String[] TACTIC_INSTRUCTION_ARR = {"Mixed", "Closing Down", "Long Ball", "Direct", "Counter", "Counter Attack"};

    public static void main(String[] args) {
        System.out.println("Start ");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            FootBallClub fbc = new FootBallClub();
            fbc.createCompetition(session, 10);
            fbc.createTactic(session);
            fbc.createOpponent(session);
            fbc.createPlayer(session);
            fbc.createFactMatch(session);
            System.out.println("Finish ");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        exit(0);
    }

    private void createCompetition(Session session, int length) {
        Transaction transaction = null;
        try {
            System.out.println("start createCompetition.");
            transaction = session.beginTransaction();
            Calendar date = new GregorianCalendar();
            int endYear = date.get(Calendar.YEAR);
            for (int year = endYear - length; year <= endYear; year++) {
                for (String competitionName : COMPETITION_NAME_ARR) {
                    int seasonStartYear = year;
                    int seasonEndYear = seasonStartYear + 1;
                    String seasonName = seasonStartYear + "/" + seasonEndYear;
                    DimCompetition d = new DimCompetition(competitionName, seasonName, seasonStartYear, seasonEndYear);
                    session.save(d);
                }
                session.flush();
                session.clear();
            }
            transaction.commit();
            System.out.println("finish createCompetition.");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    private void createTactic(Session session) {
        Transaction transaction = null;
        try {
            System.out.println("start createTactic.");
            transaction = session.beginTransaction();
            for (int i = 0; i < TACTIC_INSTRUCTION_ARR.length; i++) {
                DimTactic d = new DimTactic(TACTIC_NAME_ARR[i], TACTIC_INSTRUCTION_ARR[i]);
                session.save(d);
            }
            session.flush();
            session.clear();
            transaction.commit();
            System.out.println("finish createTactic.");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    private void createDate(Session session, Calendar cal) {
//        Transaction transaction = null;
        try {
//            System.out.println("start createDate.");
//            transaction = session.beginTransaction();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DATE);
            String season = "";
            if (month == 12 && month <= 2) {
                season = "Winter";
            } else if (month > 2 && month <= 5) {
                season = "Spring";
            } else if (month > 5 && month <= 11) {
                season = "Summer";
            } else {
                season = "Autumn";
            }
            DimDate d = new DimDate(cal.getTime(), year, month, day, season);
            session.save(d);

//            transaction.commit();
//            System.out.println("finish createDate.");
        } catch (HibernateException e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
        }
    }

    private void createOpponent(Session session) {

        Transaction transaction = null;
        try {
            System.out.println("start createOpponent.");
            transaction = session.beginTransaction();
            Reader in = new FileReader("/Users/apichart/Documents/DW_opponent/DimOpponent-Table 1.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
            for (CSVRecord record : records) {
                String longName = record.get(2);
                String shortName = record.get(3);
                DimOpponent d = new DimOpponent(longName, shortName);
                session.save(d);
            }
            in.close();
            session.flush();
            session.clear();
            transaction.commit();

            System.out.println("finish createOpponent.");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FootBallClub.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FootBallClub.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void createPlayer(Session session) {

        Transaction transaction = null;
        try {
            System.out.println("start createPlayer.");
            transaction = session.beginTransaction();
            Reader in = new FileReader("/Users/apichart/Documents/DW_opponent/DimPlayer-Table 1.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
            for (CSVRecord record : records) {
                String name = record.get(2);
                String nationality = record.get(3);
                String value = record.get(4);
                String height = record.get(6);
                String weight = record.get(7);
                DimPlayer d = new DimPlayer(name, nationality, Double.valueOf(value), Double.valueOf(height), Double.valueOf(weight));
                session.save(d);
            }
            in.close();
            session.flush();
            session.clear();
            transaction.commit();

            System.out.println("finish createPlayer.");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FootBallClub.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FootBallClub.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void createFactMatch(Session session) {
        Transaction transaction = null;
        try {
            System.out.println("start createFactMatch.");
            transaction = session.beginTransaction();
            String hqlDC = "from DimCompetition dc";
            List result = session.createQuery(hqlDC).list();
            result.forEach((object) -> {

                DimCompetition dimCompetition = (DimCompetition) object;
                int startYear = dimCompetition.getSeasonStartYear();
                int endYear = dimCompetition.getSeasonEndYear();
                GregorianCalendar cal = randomYear(startYear, endYear);
//                createDate(session, gregorianCalendar);
                if (dimCompetition.getCompetiotionName().equals(COMPETITION_NAME_ARR[0]) || dimCompetition.getCompetiotionName().equals(COMPETITION_NAME_ARR[1])) {

                    int times = randomWithRange(1, 7);
                    //Random opponent
                    String hqlDO = "from DimOpponent do";
                    List resultDO = session.createQuery(hqlDO).list();
                    HashMap<Integer, Integer> opponentMap = new HashMap<Integer, Integer>();
                    int opponentIndex;
                    do {

                        opponentIndex = randBetween(0, resultDO.size());
                        if (!opponentMap.containsKey(opponentIndex)) {
                            opponentMap.put(opponentIndex, opponentIndex);
                            generateFactMatch(opponentIndex, cal, dimCompetition.getCompetitionKy(), session);
                            //Random tactic
                            //Random player

                        }
                    } while (opponentMap.size() != times);

                } else if (dimCompetition.getCompetiotionName().equals(COMPETITION_NAME_ARR[2]) || dimCompetition.getCompetiotionName().equals(COMPETITION_NAME_ARR[3])) {

                    //Random opponent
                    String hqlDO = "from DimOpponent do";
                    List resultDO = session.createQuery(hqlDO).list();
                    HashMap<Integer, Integer> opponentMap = new HashMap<Integer, Integer>();
                    int opponentIndex;
                    do {
                        opponentIndex = randBetween(0, resultDO.size());
                        if (!opponentMap.containsKey(opponentIndex)) {
                            opponentMap.put(opponentIndex, opponentIndex);
                            generateFactMatch(opponentIndex, cal, dimCompetition.getCompetitionKy(), session);

                        }
                    } while (opponentMap.size() != 38);

                } else {

                }

            });
            session.flush();
            session.clear();
//            }
            transaction.commit();
            System.out.println("finish createFactMatch.");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateFactMatch(int opponentIndex, GregorianCalendar cal, int competitionKy, Session session) {

        int randomDay = randomWithRange(1, 3);
        cal.add(Calendar.DATE, randomDay);
        //Random tactic
        String hqlDT = "from DimTactic dt";
        List resultDT = session.createQuery(hqlDT).list();
        int tacticIndex = randomWithRange(0, resultDT.size());

        //Random player
        String hqlDP = "from DimPlayer dp";
        List resultDP = session.createQuery(hqlDP).list();
        HashMap<Integer, FactMatch> playerMap = new HashMap<Integer, FactMatch>();

        FactMeasure matchMeasure = new FactMeasure();
        matchMeasure.setHalfTimeGoals(randomWithRange(0, 2));
        matchMeasure.setFullTimeGoals(randomWithRange(matchMeasure.getHalfTimeGoals(), matchMeasure.getHalfTimeGoals() + 2));
        matchMeasure.setShot(randomWithRange(10, 25));
        matchMeasure.setFoul(randomWithRange(2, 10));
        matchMeasure.setCornner(randomWithRange(5, 15));
        matchMeasure.setYellowCard(randomWithRange(0, 5));

        int playerIndex;
        do {
            playerIndex = randBetween(0, resultDP.size());
            if (!playerMap.containsKey(playerIndex)) {

                FactMeasure m = new FactMeasure();
                m.setHalfTimeGoals(randomWithRange(0, matchMeasure.getHalfTimeGoals()));
                matchMeasure.setHalfTimeGoals(matchMeasure.getHalfTimeGoals() - m.getHalfTimeGoals());

                m.setFullTimeGoals(randomWithRange(m.getHalfTimeGoals(), matchMeasure.getFullTimeGoals()));
                matchMeasure.setFullTimeGoals(matchMeasure.getFullTimeGoals() - m.getFullTimeGoals());

                if (matchMeasure.getShot() != 0) {
                    m.setShot(randomWithRange(m.getFullTimeGoals(), matchMeasure.getShot() / 2));
                    matchMeasure.setShot(matchMeasure.getShot() - m.getShot());
                    m.setOnTarget(randomWithRange(m.getFullTimeGoals(), m.getShot()));
                    m.setOffTarget(m.getShot() - m.getOnTarget());
                }
                m.setFoul(randomWithRange(0, matchMeasure.getFoul()));
                matchMeasure.setFoul(matchMeasure.getFoul() - m.getFoul());

                int cornnerWeight = 0;
                if (matchMeasure.getCornner() != 0) {
                    cornnerWeight = randomWithRange(1, matchMeasure.getCornner());
                }
                m.setCornner(randomWithRangeAndWeight(0, matchMeasure.getCornner(), cornnerWeight));
                matchMeasure.setCornner(matchMeasure.getCornner() - m.getCornner());

                if (matchMeasure.getYellowCard() != 0 && matchMeasure.getYellowCard() >= 2) {
                    m.setYellowCard(randomWithRangeAndWeight(0, matchMeasure.getYellowCard(), matchMeasure.getYellowCard() - 2));
                    matchMeasure.setYellowCard(matchMeasure.getYellowCard() - m.getYellowCard());
                    if (m.getYellowCard() == 2) {
                        m.setRedCard(1);
                        matchMeasure.setRedCard(matchMeasure.getRedCard() - 1);
                    }

                }
                createDate(session, cal);
                FactMatch factMatch = new FactMatch(competitionKy, cal.getTime(), opponentIndex,
                        tacticIndex, playerIndex, m.getFullTimeGoals(), m.getHalfTimeGoals(),
                        m.getShot(), m.getOnTarget(), m.getOffTarget(), m.getCornner(),
                        m.getFoul(), m.getYellowCard(), m.getRedCard());

                playerMap.put(playerIndex, factMatch);
                session.save(factMatch);

            }
        } while (playerMap.size() != 13);
    }

    private GregorianCalendar randomYear(int startYear, int endYear) {

        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(startYear, endYear);
        gc.set(GregorianCalendar.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));
        gc.set(GregorianCalendar.DAY_OF_YEAR, dayOfYear);
//        System.out.println(gc.get(GregorianCalendar.YEAR) + "-" + (gc.get(GregorianCalendar.MONTH) + 1) + "-" + gc.get(GregorianCalendar.DAY_OF_MONTH));
        return gc;

    }

    private int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    private int randomWithRangeAndWeight(int min, int max, int weight) {
        int range = (max - min) + 1;
        int result = (int) (Math.random() * range) + min;
        if (result <= weight) {
            return 0;
        } else {
            return result - weight;
        }

    }
}
