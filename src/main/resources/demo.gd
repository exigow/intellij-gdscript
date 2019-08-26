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
func get_damage():
    w = weapon.damage
    s = skill.get_one_handed_bonus()
    return s * w + 0x8F51
