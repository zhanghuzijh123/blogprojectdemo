package com.jiahui.blog.services.impl;

import com.jiahui.blog.constant.ExploreEnum;
import com.jiahui.blog.pojo.Civilization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * CivilizationServiceImpl
 *
 * @author Administrator
 * @date 2021/11/4 0004
 */
@Slf4j
@Service
public class CivilizationServiceImpl {

    public void attackBarbarians(Civilization civilization) {
        Integer attack = civilization.getAttack() + civilization.getNeighbor() * 10;
        int barbariansAttack = civilization.getPerson() * 2 + 10;
        Integer barbarians = civilization.getBarbarians();
        Integer person = civilization.getPerson();
        do {
            if (attack > barbariansAttack) {
                barbarians = barbarians - 1;
            } else {
                barbariansAttack = barbariansAttack - attack;
                int death = Math.toIntExact(Math.round(attack * 0.25));
                attack = attack - death;
                person = person - death;
            }
        } while (barbariansAttack > 0);
        civilization.setAttack(attack);
        civilization.setPerson(person);
    }

    public Integer attackMySelf(Integer code, Civilization civilization) {
        int finalDefence = civilization.getDefence();
        Integer codeMinScope = 20;
        Integer codeMaxScope = 30;
        Integer barbarians = civilization.getBarbarians();
        codeMinScope = codeMinScope - barbarians * 2;
        codeMaxScope = codeMaxScope + barbarians * 2;
        if (code >= codeMinScope && code < codeMaxScope) {
            System.out.println("be attacking-----------------");
            Integer attack = civilization.getAttack() + civilization.getNeighbor() * 10;
            int barbariansAttack = civilization.getPerson() * 2 + 10;
            do {
                if (attack > barbariansAttack) {
                    barbariansAttack = -1;
                } else {
                    int value = barbariansAttack - attack;
                    finalDefence = finalDefence - value;
                    barbariansAttack = barbariansAttack - 10;
                }
            } while (barbariansAttack > 0);
            civilization.setBarbarians(barbarians - 1);
        } else {
            System.out.println("nothing---------------------");
            if (finalDefence < 100) {
                finalDefence = finalDefence + civilization.getPerson() * 2;
            }
        }
        System.out.println(finalDefence);
        return finalDefence;
    }

    public Integer getCivilizationFood(Civilization civilization) {
        System.out.println("person live----------------------");
        Integer civilizationFood = civilization.getFood();
        Integer person = civilization.getPerson();
        Integer cropper = civilization.getCropper();
        Integer campsite = civilization.getCampsite();
        if (civilizationFood >= person) {
            person = person + (civilizationFood + cropper * 10 + campsite * 20) / 5;
        } else {
//            person--;
            person = person - (int) Math.round(( person - civilizationFood ) * 0.2);
        }
        return person;
    }

    public Civilization exploreEvent(Civilization civilization) {
        Integer round = Math.toIntExact(Math.round(Math.random() * 100));
        Integer exploreCode = ExploreEnum.getExploreCode(round);
        if (exploreCode.equals(ExploreEnum.VILLAGE.getCode())) {
            civilization.setPerson(civilization.getPerson() + 1);
            System.out.println("VILLAGE+1");
        }
        if (exploreCode.equals(ExploreEnum.BARBARIANS.getCode())) {
            civilization.setBarbarians(civilization.getBarbarians() + 1);
            System.out.println("BARBARIANS+1");
        }
        if (exploreCode.equals(ExploreEnum.NEIGHBOR.getCode())) {
            civilization.setNeighbor(civilization.getNeighbor() + 1);
            System.out.println("NEIGHBOR+1");
        }
        if (exploreCode.equals(ExploreEnum.LUXURY.getCode())) {
            civilization.setLuxury(civilization.getLuxury() + 1);
            System.out.println("LUXURY+1");
        }
        if (exploreCode.equals(ExploreEnum.CROPPER.getCode())) {
            civilization.setCropper(civilization.getCropper() + 1);
            System.out.println("CROPPER+1");
        }
        if (exploreCode.equals(ExploreEnum.CAMPSITE.getCode())) {
            civilization.setCampsite(civilization.getCampsite() + 1);
            System.out.println("CAMPSITE+1");
        }
        return civilization;
    }

    public void productAttack(Civilization civilization) {
        Integer person = civilization.getPerson();
        int addAttack = civilization.getAttack() + person / 2;
        civilization.setAttack(addAttack);
    }
}
