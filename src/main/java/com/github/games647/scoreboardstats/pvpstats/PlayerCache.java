package com.github.games647.scoreboardstats.pvpstats;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString(includeFieldNames=true)
public class PlayerCache {

    private int kills;
    private int mob;
    private int deaths;

    private int highestStreak;
    private int laststreak;

    private boolean changed;

    public PlayerCache(int paramkills, int parammob, int paramdeaths, int paramstreak) {
        kills   = paramkills;
        mob     = parammob;
        deaths  = paramdeaths;
        highestStreak  = paramstreak;
    }

    public PlayerCache() {
        //Do nothing, because all variables are automatically init as 0
    }

    public void onKill() {
        onChange();

        kills++;

        laststreak++;
        if (laststreak > highestStreak) {
            highestStreak = laststreak;
        }
    }

    public void onMobKill() {
        onChange();

        mob++;
    }

    public void onDeath() {
        onChange();

        laststreak = 0;
        deaths++;
    }

    public int getKills() {
        return kills;
    }

    public int getMob() {
        return mob;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getHighestStreak() {
        return highestStreak;
    }

    public int getLaststreak() {
        return laststreak;
    }

    public int getKdr() {
        if (deaths == 0) {
            //We can't divide by zero
            return kills;
        } else {
            return (int) Math.round((double) kills / (double) deaths);
        }
    }

    public boolean hasChanged() {
        //Check if the stats was changed
        return changed;
    }

    private void onChange() {
        //Marks the stats as changed
        changed = true;
    }
}
