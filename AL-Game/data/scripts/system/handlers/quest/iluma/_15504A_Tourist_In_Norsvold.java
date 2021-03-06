/*
 * This file is part of Encom. **ENCOM FUCK OTHER SVN**
 *
 *  Encom is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Encom is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser Public License
 *  along with Encom.  If not, see <http://www.gnu.org/licenses/>.
 */
package quest.iluma;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.questEngine.handlers.*;
import com.aionemu.gameserver.questEngine.model.*;

/****/
/** Author Rinzler (Encom)
/****/

public class _15504A_Tourist_In_Norsvold extends QuestHandler
{
    private final static int questId = 15504;
	
    public _15504A_Tourist_In_Norsvold() {
        super(questId);
    }
	
    public void register() {
        qe.registerQuestNpc(806090).addOnQuestStart(questId);
        qe.registerQuestNpc(806090).addOnTalkEvent(questId);
		qe.registerQuestNpc(241508).addOnKillEvent(questId);
		qe.registerQuestNpc(241509).addOnKillEvent(questId);
		qe.registerQuestNpc(241510).addOnKillEvent(questId);
		qe.registerQuestNpc(241511).addOnKillEvent(questId);
		qe.registerQuestNpc(241512).addOnKillEvent(questId);
		qe.registerQuestNpc(241513).addOnKillEvent(questId);
		qe.registerQuestNpc(241514).addOnKillEvent(questId);
		qe.registerQuestNpc(241515).addOnKillEvent(questId);
		qe.registerQuestNpc(241516).addOnKillEvent(questId);
		qe.registerQuestNpc(241517).addOnKillEvent(questId);
		qe.registerQuestNpc(241518).addOnKillEvent(questId);
		qe.registerQuestNpc(241519).addOnKillEvent(questId);
    }
	
    @Override
    public boolean onDialogEvent(QuestEnv env) {
        Player player = env.getPlayer();
        int targetId = env.getTargetId();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        QuestDialog dialog = env.getDialog();
        if (qs == null || qs.getStatus() == QuestStatus.NONE) {
            if (targetId == 806090) {
                if (dialog == QuestDialog.START_DIALOG) {
                    return sendQuestDialog(env, 4762);
                } else {
                    return sendQuestStartDialog(env);
                }
            }
        } else if (qs.getStatus() == QuestStatus.START) {
            if (targetId == 806090) {
                if (dialog == QuestDialog.START_DIALOG) {
                    if (qs.getQuestVarById(0) == 60) {
                        return sendQuestDialog(env, 2375);
                    }
                } if (dialog == QuestDialog.SELECT_REWARD) {
                    changeQuestStep(env, 60, 61, true);
                    return sendQuestEndDialog(env);
                }
			}
        } else if (qs.getStatus() == QuestStatus.REWARD) {
            if (targetId == 806090) {
                if (env.getDialog() == QuestDialog.START_DIALOG) {
                    return sendQuestDialog(env, 10002);
				} else if (env.getDialog() == QuestDialog.SELECT_REWARD) {
					return sendQuestDialog(env, 5);
				} else {
					return sendQuestEndDialog(env);
				}
			}
		}
        return false;
    }
	
    public boolean onKillEvent(QuestEnv env) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        if (qs != null && qs.getStatus() == QuestStatus.START) {
            switch (env.getTargetId()) {
                case 241508:
                case 241509:
                case 241510:
                case 241511:
                case 241512:
                case 241513:
                case 241514:
                case 241515:
                case 241516:
                case 241517:
                case 241518:
                case 241519:
                if (qs.getQuestVarById(1) < 60) {
					qs.setQuestVarById(1, qs.getQuestVarById(1) + 1);
					updateQuestStatus(env);
				} if (qs.getQuestVarById(1) >= 60) {
					qs.setStatus(QuestStatus.REWARD);
					updateQuestStatus(env);
				}
            }
        }
        return false;
    }
}