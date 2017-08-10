package me.nerm.scoreboard;

import me.signatured.ezqueueshared.QueueInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import me.nerm.Main;

public class ScoreboardManager {

	public static void giveScoreboard(Player p) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("MAIN", "MAIN");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("SCOREBOARDTITLE")));

		Team BAR = board.registerNewTeam("BAR");
		BAR.addEntry("§9");
		BAR.setPrefix("§7§m----------");
		BAR.setSuffix("§7§m----------");
		obj.getScore("§9").setScore(9);

		Team rank = board.registerNewTeam("rank");
		rank.addEntry("§8");
		rank.setPrefix("§2§lRank§7:");
		rank.setSuffix("");
		obj.getScore("§8").setScore(8);

		Team rank_rank = board.registerNewTeam("rank_rank");
		rank_rank.addEntry("§7");
		rank_rank.setSuffix("§f" + Main.getPerms().getPrimaryGroup(p));
		obj.getScore("§7").setScore(7);

		Score blank2 = obj.getScore("§b");
		blank2.setScore(6);

		Team online = board.registerNewTeam("online");
		online.addEntry("§5");
		online.setPrefix("§2§lOnline§7:");
		obj.getScore("§5").setScore(5);

		Team online_online = board.registerNewTeam("online_online");
		online_online.addEntry("§4");
		online_online.setSuffix("§f" + String.valueOf(Bukkit.getOnlinePlayers().size()));
		obj.getScore("§4").setScore(4);

		Score blank3 = obj.getScore("§2");
		blank3.setScore(2);

		Team spon = board.registerNewTeam("spon");
		spon.addEntry("§1");
		spon.setPrefix("§astore.exort");
		spon.setSuffix("§ahq.net");
		obj.getScore("§1").setScore(1);

		Team BAR2 = board.registerNewTeam("BAR2");
		BAR2.addEntry("§0");
		BAR2.setPrefix("§7§m----------");
		BAR2.setSuffix("§7§m----------");
		obj.getScore("§0").setScore(0);

		p.setScoreboard(board);
	}

	@SuppressWarnings("deprecation")
	public static void updateScoreboard() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.getScoreboard() != null) {
				p.getScoreboard().getTeam("online_online")
						.setSuffix(String.valueOf("§f" + Bukkit.getOnlinePlayers().size()));
				p.getScoreboard().getTeam("rank_rank").setSuffix("§f" + Main.getPerms().getPrimaryGroup(p));
				if (!getMaxInQueue(p).equals("")) {
					if (p.getScoreboard().getTeam("QUEUE") == null) {
						p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("§2").setScore(0);
						p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("§1").setScore(-1);
						p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("§0").setScore(-2);

						Score blank4 = p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("§m");
						blank4.setScore(3);

						Team QUEUE_SERVER = p.getScoreboard().registerNewTeam("QUEUE_SERVER");
						QUEUE_SERVER.addEntry("§a");
						QUEUE_SERVER.setPrefix("§3Queued for§7: ");
						QUEUE_SERVER.setSuffix("§b§l" + QueueInfo.getQueue(p.getName()));
						p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("§a").setScore(2);

						Team QUEUE = p.getScoreboard().registerNewTeam("QUEUE");
						QUEUE.addEntry("§e");
						QUEUE.setPrefix("§n" + getQueue(p));
						QUEUE.setSuffix(getMaxInQueue(p));
						p.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("§e").setScore(1);
					}
					p.getScoreboard().getTeam("QUEUE_SERVER").setSuffix("§3§l" + QueueInfo.getQueue(p.getName()));
					p.getScoreboard().getTeam("QUEUE").setPrefix("§n" + getQueue(p));
					p.getScoreboard().getTeam("QUEUE").setSuffix(getMaxInQueue(p));
				} else {
					if (p.getScoreboard().getTeam("QUEUE") != null) {
						giveScoreboard(p);
					}
				}
			}
		}
	}

	private static String getMaxInQueue(Player p) {
		if (QueueInfo.getQueue(p.getName()) == null) {
			return "";
		}
		return "§f§n" + QueueInfo.getQueueInfo(QueueInfo.getQueue(p.getName())).getSize();
	}

	private static String getQueue(Player p) {
		if (QueueInfo.getPosition(p.getName()) == -1) {
			return "";
		}
		return "#" + QueueInfo.getPosition(p.getName()) + " out of #";
	}
}
