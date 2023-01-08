package gg.rsmod.plugins.content.npcs.definitions

import gg.rsmod.plugins.content.drops.DropTableFactory
import gg.rsmod.plugins.content.combat.getLastHitBy
import gg.rsmod.plugins.content.drops.shared.Herbs.minorHerbTable

val ids = intArrayOf(Npcs.RAT)

val table = DropTableFactory
val citizen = table.build {
    guaranteed {
        obj(Items.BONES)
    }
}

table.register(citizen, *ids)

on_npc_death(*ids) {
    table.getDrop(world, npc.getLastHitBy()!!, npc.id, npc.tile)
}

ids.forEach {
    set_combat_def(it) {
        configs {
            attackSpeed = 4
            respawnDelay = 1
        }
        stats {
            hitpoints = 2
            attack = 1
            strength = 1
            defence = 1
            magic = 1
            ranged = 1
        }
        bonuses {
            attackStab = -47
            attackCrush = -53
            defenceStab = -42
            defenceSlash = -42
            defenceCrush = -42
            defenceMagic = -42
            defenceRanged = -42
        }
        anims {
            attack = 2705
            death = 2707
            block = 2706
        }
    }
}