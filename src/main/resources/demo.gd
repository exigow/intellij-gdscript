extends Node
class_name Hero, "res://interface/icons/hero.png"
export(Texture) var face
const MAX_HP = 200
var hp = 100.0 # Health
var item = Potion()
enum Class {ROGUE, KNIGHT, WIZARD}
"""
Roses are red
Violets are blue
"""
var cloth_color: Color = blueviolet
func get_damage(is_critical: bool, multiplier: int) -> float:
    var dmg = weapon.damage + skill.get_one_handed_bonus()
    var array = [1, 2, 3]
    for i in array:
        dmg += i % array[-1]
    return dkg * 0x8F51
