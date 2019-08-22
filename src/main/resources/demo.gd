extends Node
class_name Hero, "res://interface/icons/hero.png"

export(Texture) var face
var hp = 100 # Health

enum Class {ROGUE, KNIGHT, WIZARD}

func get_damage():
    return 0
