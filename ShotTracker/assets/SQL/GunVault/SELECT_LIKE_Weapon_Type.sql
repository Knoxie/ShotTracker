SELECT weapon, type FROM Weapon JOIN WeaponType ON Weapon.id = WeaponType.weapon_id JOIN Type ON Type.id = WeaponType.type_id WHERE weapon LIKE '

%'