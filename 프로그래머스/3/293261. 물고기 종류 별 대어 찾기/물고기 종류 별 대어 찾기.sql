SELECT 
    i.id,
    t.fish_name,
    t.length
FROM fish_info i
JOIN (
    SELECT 
        n.fish_type,
        n.fish_name,
        MAX(f.length) as length
    FROM fish_info f
    JOIN fish_name_info n ON f.fish_type = n.fish_type
    GROUP BY fish_name, fish_type
)t ON i.fish_type = t.fish_type AND i.length = t.length
